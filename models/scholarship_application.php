<?php

class ScholarshipApplication {
    private $db;
    private $table = "scholarship_applications";

    public $id;
    public $reviewer_id;
    public $application_name;
    public $application_description;
    public $duration;
    public $application_image;
    public $category;
    public $slots;
    public $deadline;

    public function __construct($db) {
        $this->db = $db;
    }

    public function create() {
        $query = "INSERT INTO " . $this->table . " (reviewer_id, application_name, application_description, duration, application_image, category, slots, deadline)
                  VALUES (:reviewer_id, :application_name, :application_description, :duration, :application_image, :category, :slots, :deadline)";
        $stmt = $this->db->prepare($query);

        // Bind values
        $stmt->bindParam(':reviewer_id', $this->reviewer_id);
        $stmt->bindParam(':application_name', $this->application_name);
        $stmt->bindParam(':application_description', $this->application_description);
        $stmt->bindParam(':duration', $this->duration);
        $stmt->bindParam(':application_image', $this->application_image);
        $stmt->bindParam(':category', $this->category);
        $stmt->bindParam(':slots', $this->slots);
        $stmt->bindParam(':deadline', $this->deadline);

        if ($stmt->execute()) {
            $this->id = $this->db->lastInsertId();
            return true;
        }
        return false;
    }

    public function getAll() {
        $query = "SELECT * FROM " . $this->table;
        $stmt = $this->db->prepare($query);
        $stmt->execute();

        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    public function getByReviewerId($reviewerId) {
        $query = "SELECT * FROM " . $this->table . " WHERE reviewer_id = :reviewer_id";
        $stmt = $this->db->prepare($query);
        $stmt->bindParam(':reviewer_id', $reviewerId);
        $stmt->execute();

        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    public function update() {
        $query = "UPDATE " . $this->table . " SET 
                  application_name = :application_name, 
                  application_description = :application_description, 
                  duration = :duration, 
                  application_image = :application_image, 
                  category = :category, 
                  slots = :slots, 
                  deadline = :deadline
                  WHERE id = :id AND reviewer_id = :reviewer_id";

        $stmt = $this->db->prepare($query);

        $stmt->bindParam(':id', $this->id);
        $stmt->bindParam(':reviewer_id', $this->reviewer_id);
        $stmt->bindParam(':application_name', $this->application_name);
        $stmt->bindParam(':application_description', $this->application_description);
        $stmt->bindParam(':duration', $this->duration);
        $stmt->bindParam(':application_image', $this->application_image);
        $stmt->bindParam(':category', $this->category);
        $stmt->bindParam(':slots', $this->slots);
        $stmt->bindParam(':deadline', $this->deadline);

        return $stmt->execute();
    }

    public function delete() {
        $query = "DELETE FROM " . $this->table . " WHERE id = :id AND reviewer_id = :reviewer_id";
        $stmt = $this->db->prepare($query);
        $stmt->bindParam(':id', $this->id);
        $stmt->bindParam(':reviewer_id', $this->reviewer_id);

        return $stmt->execute();
    }
}


?>