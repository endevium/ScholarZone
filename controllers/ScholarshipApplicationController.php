<?php

require_once 'models/scholarship_application.php';
require_once 'models/reviewer.php';

class ScholarshipApplicationController {
    private $db;

    public function __construct($db) {
        $this->db = $db;
    }

    public function createApplication($data, $token) {
        $reviewerId = (new ReviewerController($this->db))->validateToken($token);

        if ($reviewerId) {
            $application = new ScholarshipApplication($this->db);
            $application->reviewer_id = $reviewerId;
            $application->application_name = $data['application_name'];
            $application->application_description = $data['application_description'];
            $application->duration = $data['duration'];
            $application->application_image = isset($data['application_image']) ? $data['application_image'] : '';
            $application->category = $data['category'];
            $application->slots = $data['slots'];
            $application->deadline = $data['deadline'];

            if ($application->create()) {
                $this->storeToken($application->id, $token);

                return [
                    "status" => 201,
                    "message" => "Scholarship application created successfully."
                ];
            } else {
                return [
                    "status" => 500,
                    "message" => "Failed to create scholarship application."
                ];
            }
        } else {
            return [
                "status" => 401,
                "message" => "Unauthorized: Invalid token."
            ];
        }
    }

    public function getAllApplications() {
        $application = new ScholarshipApplication($this->db);
        $applications = $application->getAll();
        
        if ($applications) {
            return [
                "status" => 200,
                "data" => $applications
            ];
        } else {
            return [
                "status" => 404,
                "message" => "No applications found."
            ];
        }
    }

    public function getReviewerApplications($token) {
        $reviewerId = (new ReviewerController($this->db))->validateToken($token);

        if ($reviewerId) {
            $application = new ScholarshipApplication($this->db);
            $applications = $application->getByReviewerId($reviewerId);

            if ($applications) {
                return [
                    "status" => 200,
                    "data" => $applications
                ];
            } else {
                return [
                    "status" => 404,
                    "message" => "No applications found for this reviewer."
                ];
            }
        } else {
            return [
                "status" => 401,
                "message" => "Unauthorized: Invalid token."
            ];
        }
    }

    public function updateApplication($data, $token) {
        $reviewerId = (new ReviewerController($this->db))->validateToken($token);

        if ($reviewerId) {
            $application = new ScholarshipApplication($this->db);
            $application->id = $data['id'];
            $application->reviewer_id = $reviewerId;
            $application->application_name = $data['application_name'];
            $application->application_description = $data['application_description'];
            $application->duration = $data['duration'];
            $application->application_image = isset($data['application_image']) ? $data['application_image'] : '';
            $application->category = $data['category'];
            $application->slots = $data['slots'];
            $application->deadline = $data['deadline'];

            if ($application->update()) {
                return [
                    "status" => 200,
                    "message" => "Scholarship application updated successfully."
                ];
            } else {
                return [
                    "status" => 500,
                    "message" => "Failed to update scholarship application."
                ];
            }
        } else {
            return [
                "status" => 401,
                "message" => "Unauthorized: Invalid token."
            ];
        }
    }

    public function deleteApplication($id, $token) {
        $reviewerId = (new ReviewerController($this->db))->validateToken($token);

        if ($reviewerId) {
            $application = new ScholarshipApplication($this->db);
            $application->id = $id;
            $application->reviewer_id = $reviewerId;

            if ($application->delete()) {
                return [
                    "status" => 200,
                    "message" => "Scholarship application deleted successfully."
                ];
            } else {
                return [
                    "status" => 500,
                    "message" => "Failed to delete scholarship application."
                ];
            }
        } else {
            return [
                "status" => 401,
                "message" => "Unauthorized: Invalid token."
            ];
        }
    }

    public function storeToken($scholarshipApplicationId, $token) {
        $query = "INSERT INTO scholarship_tokens (scholarship_application_id, token) VALUES (:scholarship_application_id, :token)";
        $stmt = $this->db->prepare($query);
        $stmt->bindParam(':scholarship_application_id', $scholarshipApplicationId);
        $stmt->bindParam(':token', $token);
        $stmt->execute();
    } 
}


?>