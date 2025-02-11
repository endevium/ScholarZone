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
        $user->full_address = htmlspecialchars(strip_tags($data['full_address'] ?? ''));
        $user->rpc = htmlspecialchars(strip_tags($data['rpc'] ?? ''));
        $user->bsb = htmlspecialchars(strip_tags($data['bsb'] ?? ''));


        if ($user->create()) {
            return [
                "status" => 201,
                "message" => "Reviewer Account registered successfully."
            ];
        } else {
            return [
                "status" => 500,
                "message" => "Failed to register the user."
            ];
        }
    }

    public function login($email, $password) {
        try {
            // Query the database for the user
            $query = "SELECT * FROM reviewers WHERE email = :email";
            $stmt = $this->db->prepare($query);
            $stmt->execute([':email' => $email]);

            $user = $stmt->fetch(PDO::FETCH_ASSOC);

            // Check if user exists
            if (!$user) {
                return [
                    "status" => 404,
                    "message" => "User not found."
                ];
            }

            // Verify password
            if (!password_verify($password, $user['password'])) {
                return [
                    "status" => 401,
                    "message" => "Invalid email or password."
                ];
            }

            // Generate a token (optional)
            $token = bin2hex(random_bytes(32));

            // Return success response
            return [
                "status" => 200,
                "message" => "Login successful.",
                "data" => [
                    "user_id" => $user['id'],
                    "email" => $user['email'],
                    "token" => $token
                ]
            ];
        } catch (PDOException $e) {
            return [
                "status" => 500,
                "message" => "Database error: " . $e->getMessage()
            ];
        }
    }

}

?>
