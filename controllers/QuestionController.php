<?php

require_once 'models/question.php';
require_once 'models/reviewer.php';

class QuestionController {
    private $db;

    public function __construct($db) {
        $this->db = $db;
    }

    public function createQuestion($data, $token) {
        $reviewerId = (new ReviewerController($this->db))->validateToken($token);

        error_log("Received scholarship_application_id: " . $data['scholarship_application_id']);
        error_log("Received question: " . $data['question']);
        if ($reviewerId) {
            $question = new Question($this->db);
            $question->scholarship_application_id = $data['scholarship_application_id'];
            $question->question = $data['question'];
            
            if ($question->create()) {
                return [
                    "status" => 201,
                    "message" => "Question created successfully."
                ];
            } else {
                return [
                    "status" => 400,
                    "message" => "Invalid scholarship application ID or failed to create question."
                ];
        }
        } else {
            return [
                "status" => 401,
                "message" => "Unauthorized: Invalid token."
            ];
        }
    }
    
    public function getAllQuestions($scholarship_application_id) {
        $question = new Question($this->db);
        $questions = $question->getQuestions($scholarship_application_id);
    
        if (count($questions) > 0) {
            return [
                "status" => 200,
                "data" => $questions
            ];
        } else {
            return [
                "status" => 404,
                "message" => "No questions found for this scholarship application."
            ];
        }
    }
    
    public function updateQuestion($id, $data, $token) {
        $reviewerId = (new ReviewerController($this->db))->validateToken($token);

        if ($reviewerId) {
            $question = new Question($this->db);
            $question->id = $id;
            $question->scholarship_application_id = $data['scholarship_application_id'];
            $question->question = $data['question'];
    
            if ($question->update()) {
                return [
                    "status" => 200,
                    "message" => "Question updated successfully."
                ];
            } else {
                return [
                    "status" => 400,
                    "message" => "Failed to update question."
                ];
            }
        } else {
            return [
                "status" => 401,
                "message" => "Unauthorized: Invalid token."
            ];
        }
    
        
    }
    
    public function deleteQuestion($id, $data, $token) {
        $reviewerId = (new ReviewerController($this->db))->validateToken($token);

        if ($reviewerId) {
            $question = new Question($this->db);
            $question->id = $id;
            $question->scholarship_application_id = $data['scholarship_application_id'];
    
            if ($question->delete()) {
                return [
                    "status" => 200,
                    "message" => "Question deleted successfully."
                ];
            } else {
                return [
                    "status" => 400,
                    "message" => "Failed to delete question."
                ];
            }
        } else {
            return [
                "status" => 401,
                "message" => "Unauthorized: Invalid token."
            ];
        }
    }
    
}

?>