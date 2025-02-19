<?php

require_once 'models/applicant.php';

class ApplicantController {
    private $db;

    public function __construct($db) {
        $this->db = $db;
    }

    public function signUp($data) {
        $user = new Applicant($this->db);

        $user->username = htmlspecialchars(strip_tags($data['username']));
        $user->email = htmlspecialchars(strip_tags($data['email']));
        $user->password = password_hash(htmlspecialchars(strip_tags($data['password'])), PASSWORD_BCRYPT);
        $user->firstname = htmlspecialchars(strip_tags($data['firstname']));
        $user->lastname = htmlspecialchars(strip_tags($data['lastname']));
        $user->gender = htmlspecialchars(strip_tags($data['gender']));
        $user->birthdate = htmlspecialchars(strip_tags($data['birthdate']));
        $user->phone_number = htmlspecialchars(strip_tags($data['phone_number']));
        $user->school = htmlspecialchars(strip_tags($data['school'] ?? ''));
        $user->program = htmlspecialchars(strip_tags($data['program'] ?? ''));
        $user->rpc = htmlspecialchars(strip_tags($data['rpc'] ?? ''));
        $user->bsb = htmlspecialchars(strip_tags($data['bsb'] ?? ''));

        if ($user->create()) {
            $user->id = $this->db->lastInsertId();
            $token = bin2hex(random_bytes(32));
            $this->storeToken($user->id, $token);
    
            return [
                "status" => 201,
                "message" => "Applicant registered successfully.",
                "id" => $user->id,
                "token" => $token
            ];
        } else {
            return [
                "status" => 500,
                "message" => "Failed to register applicant."
            ];
        }
    }


    public function login($email, $password) {
        try {
            $query = "SELECT * FROM applicants WHERE email = :email";
            $stmt = $this->db->prepare($query);
            $stmt->execute([':email' => $email]);

            $user = $stmt->fetch(PDO::FETCH_ASSOC);

            if (!$user) {
                return [
                    "status" => 404,
                    "message" => "User not found."
                ];
            }

            if (!password_verify($password, $user['password'])) {
                return [
                    "status" => 401,
                    "message" => "Invalid email or password."
                ];
            }

            $token = bin2hex(random_bytes(32));

            $this->storeToken($user['id'], $token);

            return [
                "status" => 200,
                "message" => "Login successful.",
                "id" => $user['id'],
                "token" => $token
            ];
        } catch (PDOException $e) {
            return [
                "status" => 500,
                "message" => "Database error: " . $e->getMessage()
            ];
        }
    }

    public function getApplicantById($id) {
        $applicant = new Applicant($this->db);
        $result = $applicant->getById($id);

        if ($result) {
            return [
                "status" => 200,
                "data" => $result
            ];
        } else {
            return [
                "status" => 404,
                "message" => "Applicant not found"
            ];
        }

    }

    public function storeToken($applicantId, $token) {
        $query = "INSERT INTO applicant_tokens (applicant_id, token) VALUES (:applicant_id, :token)";
        $stmt = $this->db->prepare($query);
        $stmt->bindParam(':applicant_id', $applicantId);
        $stmt->bindParam(':token', $token);
        $stmt->execute();
    }   

    public function updateProfile($token, $data) {
        $applicant = new Applicant($this->db);
        $user = $applicant->getByToken($token);
    
        if (!$user) {
            return [
                "status" => 401,
                "message" => "Invalid token or user not found."
            ];
        }
    
        $updatableFields = ['username', 'email', 'firstname', 'lastname', 'gender', 'birthdate', 'phone_number', 'school', 'program', 'rpc', 'bsb'];
    
        $updateData = [];
        foreach ($data as $key => $value) {
            if (in_array($key, $updatableFields) && !empty($value)) {
                $updateData[$key] = $value;
            }
        }
    
        if (empty($updateData)) {
            return [
                "status" => 400,
                "message" => "No valid fields provided for update."
            ];
        }
    
        if ($applicant->update($user['id'], $updateData)) {
            return [
                "status" => 200,
                "message" => "Profile updated successfully."
            ];
        } else {
            return [
                "status" => 500,
                "message" => "Failed to update profile."
            ];
        }
    }
}

?>
