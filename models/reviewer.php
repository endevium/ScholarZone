<?php

class Reviewer {
    private $conn;
    private $table = "reviewers";

    public $username;
    public $email;
    public $password;
    public $firstname;
    public $lastname;
    public $gender;
    public $birthdate;
    public $phone_number;
    public $company;
    public $full_address;
    public $rpc;
    public $bsb;

    public function __construct($db) {
        $this->conn = $db;
    }

    public function create() {
        $query = "INSERT INTO " . $this->table . " 
            (username, email, password, firstname, lastname, gender, birthdate, phone_number, company, full_address, rpc, bsb)
            VALUES (:username, :email, :password, :firstname, :lastname, :gender, :birthdate, :phone_number, :company, :full_address, :rpc, :bsb)";
        
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
        $stmt->bindParam(':full_address', $this->full_address);
        $stmt->bindParam(':rpc', $this->rpc);
        $stmt->bindParam(':bsb', $this->bsb);

        return $stmt->execute();
    }
}

?>