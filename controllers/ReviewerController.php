<?php

require_once 'models/reviewer.php';

class ReviewerController {
    private $db;

    public function __construct($db) {
        $this->db = $db;
    }

    public function signUp($data) {
        $user = new Reviewer($this->db);

        // Assign sanitized data to user properties
        $user->username = htmlspecialchars(strip_tags($data['username']));
        $user->email = htmlspecialchars(strip_tags($data['email']));
        $user->password = password_hash(htmlspecialchars(strip_tags($data['password'])), PASSWORD_BCRYPT);
        $user->firstname = htmlspecialchars(strip_tags($data['firstname']));
        $user->lastname = htmlspecialchars(strip_tags($data['lastname']));
        $user->gender = htmlspecialchars(strip_tags($data['gender']));
        $user->birthdate = htmlspecialchars(strip_tags($data['birthdate']));
        $user->phone_number = htmlspecialchars(strip_tags($data['phone_number']));
        $user->company = htmlspecialchars(strip_tags($data['company']));
        $user->rpc = htmlspecialchars(strip_tags($data['rpc'] ?? ''));
        $user->bsb = htmlspecialchars(strip_tags($data['bsb'] ?? ''));

        if ($user->create()) {
            $user->id = $this->db->lastInsertId();
            $token = bin2hex(random_bytes(32));
            $this->storeToken($user->id, $token);
    
            return [
                "status" => 201,
                "message" => "Reviewer registered successfully.",
                "token" => $token
            ];
        } else {
            return [
                "status" => 500,
                "message" => "Failed to register reviewer"
            ];
        }
    }

    public function login($email, $password) {
        try {
            $query = "SELECT * FROM reviewers WHERE email = :email";
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
                "token" => $token
            ];
        } catch (PDOException $e) {
            return [
                "status" => 500,
                "message" => "Database error: " . $e->getMessage()
            ];
        }
    }


    public function getReviewerById($id) {
        $reviewer = new Reviewer($this->db);
        $result = $reviewer->getById($id);

        if ($result) {
            return [
                "status" => 200,
                "data" => $result
            ];
        } else {
            return [
                "status" => 404,
                "message" => "Reviewer not found"
            ];
        }

    }

    public function storeToken($reviewerId, $token) {
        $query = "INSERT INTO reviewer_tokens (reviewer_id, token) VALUES (:reviewer_id, :token)";
        $stmt = $this->db->prepare($query);
        $stmt->bindParam(':reviewer_id', $reviewerId);
        $stmt->bindParam(':token', $token);
        $stmt->execute();
    }    

    public function validateToken($token) {
        $query = "SELECT reviewer_id FROM reviewer_tokens WHERE token = :token";
        $stmt = $this->db->prepare($query);
        $stmt->bindParam(':token', $token);
        $stmt->execute();
    
        $result = $stmt->fetch(PDO::FETCH_ASSOC);
        if ($result) {
            return $result['reviewer_id'];
        }
    
        return null;
    }


    public function updateProfile($token, $data) {
        $reviewer = new Reviewer($this->db);
        $user = $reviewer->getByToken($token);
    
        if (!$user) {
            return [
                "status" => 401,
                "message" => "Invalid token or user not found."
            ];
        }
    
        // Allowable fields that can be updated
        $updatableFields = ['username', 'email', 'firstname', 'lastname', 'gender', 'birthdate', 'phone_number', 'school', 'program'];
    
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
    
        if ($reviewer->update($user['id'], $updateData)) {
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
