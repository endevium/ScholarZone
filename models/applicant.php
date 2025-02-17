<?php

class Applicant {
    private $conn;
    private $table = "applicants";

    public $id;
    public $username;
    public $email;
    public $password;
    public $firstname;
    public $lastname;
    public $gender;
    public $birthdate;
    public $phone_number;
    public $school;
    public $program;
    public $rpc;
    public $bsb;

    public function __construct($db) {
        $this->conn = $db;
    }

    public function create() {
        $query = "INSERT INTO " . $this->table . " 
            (username, email, password, firstname, lastname, gender, birthdate, phone_number, school, program, rpc, bsb)
            VALUES (:username, :email, :password, :firstname, :lastname, :gender, :birthdate, :phone_number, :school, :program, :rpc, :bsb)";
        
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
        $stmt->bindParam(':school', $this->school);                             
        $stmt->bindParam(':program', $this->program);
        $stmt->bindParam(':rpc', $this->rpc);
        $stmt->bindParam(':bsb', $this->bsb);

        return $stmt->execute();
    }
}

?>