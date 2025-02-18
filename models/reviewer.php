<?php

class Reviewer {
    private $conn;
    private $table = "reviewers";

    public $id;
    public $username;
    public $email;
    public $password;
    public $firstname;
    public $lastname;
    public $gender;
    public $birthdate;
    public $phone_number;
    public $company;
    public $rpc;
    public $bsb;

    public function __construct($db) {
        $this->conn = $db;
    }

    public function create() {
        $query = "INSERT INTO " . $this->table . " 
            (username, email, password, firstname, lastname, gender, birthdate, phone_number, company, rpc, bsb)
            VALUES (:username, :email, :password, :firstname, :lastname, :gender, :birthdate, :phone_number, :company, :rpc, :bsb)";
        
        $stmt = $this->conn->prepare($query);

        // Bind and sanitize data
        $stmt->bindParam(':username', $this->username);
        $stmt->bindParam(':email', $this->email);
        $stmt->bindParam(':password', $this->password);
        $stmt->bindParam(':firstname', $this->firstname);
        $stmt->bindParam(':lastname', $this->lastname);
        $stmt->bindParam(':gender', $this->gender);
        $stmt->bindParam(':birthdate', $this->birthdate);
        $stmt->bindParam(':phone_number', $this->phone_number);     
        $stmt->bindParam(':company', $this->company);                    
        $stmt->bindParam(':rpc', $this->rpc);
        $stmt->bindParam(':bsb', $this->bsb);

        return $stmt->execute();
    }

    public function getById($id) {
        $query = "SELECT * FROM " . $this->table . " WHERE id = :id LIMIT 1";
        $stmt = $this->conn->prepare($query);
        $stmt->bindParam(':id', $id, PDO::PARAM_INT);
        $stmt->execute();

        return $stmt->fetch(PDO::FETCH_ASSOC);
    }

    public function getByToken($token) {
        $query = "SELECT a.* FROM " . $this->table . " a 
                  JOIN reviewer_tokens t ON a.id = t.reviewer_id 
                  WHERE t.token = :token";
        $stmt = $this->conn->prepare($query);
        $stmt->bindParam(":token", $token);
        $stmt->execute();
        return $stmt->fetch(PDO::FETCH_ASSOC);
    }


    public function update($id, $fields) {
        $setClause = [];
        foreach ($fields as $key => $value) {
            $setClause[] = "$key = :$key";
        }

        $query = "UPDATE " . $this->table . " SET " . implode(", ", $setClause) . " WHERE id = :id";
        $stmt = $this->conn->prepare($query);
        $stmt->bindParam(":id", $id);

        foreach ($fields as $key => $value) {
            $stmt->bindValue(":$key", htmlspecialchars(strip_tags($value)));
        }

        return $stmt->execute();
    }   


}

?>