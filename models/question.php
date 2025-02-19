<?php

class Question {
    private $db;
    private $table = "questions";

    public $id;
    public $scholarship_application_id;
    public $question;

    public function __construct($db) {
        $this->db = $db;
    }

    public function create() {
        $query = "SELECT id FROM scholarship_applications WHERE id = :scholarship_application_id";
        $stmt = $this->db->prepare($query);
        $stmt->bindParam(':scholarship_application_id', $this->scholarship_application_id);
        $stmt->execute();
    
        if ($stmt->rowCount() == 0) {
            return false;
        }

        $query = "INSERT INTO " . $this->table . " (scholarship_application_id, question)
                  VALUES (:scholarship_application_id, :question)";
        $stmt = $this->db->prepare($query);

        $stmt->bindParam(':scholarship_application_id', $this->scholarship_application_id);
        $stmt->bindParam(':question', $this->question);
    
        return $stmt->execute();
    }
    
    public function getQuestions($scholarship_application_id) {
        $query = "SELECT id, question FROM " . $this->table . " WHERE scholarship_application_id = :scholarship_application_id";
        $stmt = $this->db->prepare($query);
        $stmt->bindParam(':scholarship_application_id', $scholarship_application_id);
        $stmt->execute();
        
        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    public function getQuestionById($id) {
        $query = "SELECT * FROM " . $this->table . " WHERE id = :id LIMIT 1";
        $stmt = $this->db->prepare($query);
        $stmt->bindParam(':id', $id);
        $stmt->execute();
    
        return $stmt->fetch(PDO::FETCH_ASSOC);
    }

    public function update() {
        $query = "UPDATE " . $this->table . " SET question = :question WHERE id = :id AND scholarship_application_id = :scholarship_application_id";
        $stmt = $this->db->prepare($query);

        $stmt->bindParam(':question', $this->question);
        $stmt->bindParam(':id', $this->id);
        $stmt->bindParam(':scholarship_application_id', $this->scholarship_application_id);

        return $stmt->execute();
    }

    public function delete() {
        $query = "DELETE FROM " . $this->table . " WHERE id = :id AND scholarship_application_id = :scholarship_application_id";
        $stmt = $this->db->prepare($query);

        $stmt->bindParam(':id', $this->id);
        $stmt->bindParam(':scholarship_application_id', $this->scholarship_application_id);

        return $stmt->execute();
    }   
}

?>