<?php

require_once 'models/application.php';
require_once 'models/reviewer.php';

class ApplicationController {
    private $db;

    public function __construct($db) {
        $this->db = $db;
    }

    public function createApplication($data, $token) {
        $applicant = (new Applicant($this->db))->getByToken($token);

        if ($applicant) {
            $application = new Application($this->db);
            $application->scholarship_application_id = $data['scholarship_application_id'];
            $application->applicant_id = $applicant['id'];
            $application->status = 'pending';
            
            if ($application->create()) {
                return [
                    "status" => 201,
                    "message" => "Application submitted successfully."
                ];
            } else {
                return [
                    "status" => 500,
                    "message" => "Failed to submit application."
                ];
            }
        } else {
            return [
                "status" => 401,
                "message" => "Unauthorized: Invalid token."
            ];
        }
    }

    public function getApplicationsById($scholarship_id) {
        $application = new Application($this->db);
        $application->scholarship_application_id = $scholarship_id;
        $applications = $application->getApplicationsByScholarship();

        if (!empty($applications)) {
            return [
                "status" => 200,
                "data" => $applications
            ];
        } else {
            return [
                "status" => 404,
                "message" => "No applications found for this scholarship."
            ];
        }
    }

    public function getApplicantApplications($applicant_id) {
        $application = new Application($this->db);
        $result = $application->getApplicantApplications($applicant_id);

        if (!is_array($result)) {
            return [
                "status" => 500,
                "message" => "Unexpected error: Expected array but got void or null."
            ];
        }

        if ($result) {
            return [
                "status" => 200,
                "data" => $result
            ];
        } else {
            return [
                "status" => 404,
                "message" => "No application details found."
            ];
        }
    }

    public function updateApplicationStatus($id, $status, $token) {
        $reviewer = (new Reviewer($this->db))->getByToken($token);

        if ($reviewer) {
            $application = new Application($this->db);
            $application->id = $id;
            $application->status = $status;

            if ($application->updateStatus()) {
                return [
                    "status" => 200,
                    "message" => "Application status updated successfully."
                ];
            } else {
                return [
                    "status" => 500,
                    "message" => "Failed to update application status."
                ];
            }
        } else {
            return [
                "status" => 401,
                "message" => "Unauthorized: Invalid token."
            ];
        }
    }

    public function getNotifications($applicantId) {
        $notification = new Application(db: $this->db);
        $notifications = $notification->getNotifications($applicantId);
        
        if ($notifications) {
            return [
                "data" => $notifications
            ];
        } else {
            return [
                "status" => 404,
                "message" => "No notifications found."
            ];
        }
    }
}

?>
