<?php

require_once 'models/generate_token.php';
class Application {
    private $db;
    public $id;
    public $scholarship_application_id;
    public $applicant_id;
    public $status;
    public $submitted_at;

    public function __construct($db) {
        $this->db = $db;
    }

    public function create() {
        $query = "INSERT INTO applications (scholarship_application_id, applicant_id, status) VALUES (?, ?, 'pending')";
        $stmt = $this->db->prepare($query);
        $stmt->bindValue(1, $this->scholarship_application_id, PDO::PARAM_INT);
        $stmt->bindValue(2, $this->applicant_id, PDO::PARAM_INT);
        return $stmt->execute();
    }

    public function getApplicationsByScholarship() {
        $query = "SELECT 
                    sa.id AS application_id, sa.status, sa.submitted_at,
                    a.id AS applicant_id, a.username, a.email, a.firstname, a.lastname, a.gender,
                    a.birthdate, a.phone_number, a.school, a.program, a.rpc, a.bsb,
                    s.id AS scholarship_application_id, s.application_name AS application_name, 
                    s.company AS company, s.duration AS duration, s.category AS category,
                    s.application_image AS application_image, s.application_description AS application_description, 
                    s.slots AS slots, s.deadline,
                    q.id AS question_id, q.question,
                    ans.answer
                  FROM applications sa
                  JOIN applicants a ON sa.applicant_id = a.id
                  JOIN scholarship_applications s ON sa.scholarship_application_id = s.id
                  LEFT JOIN questions q ON q.scholarship_application_id = sa.scholarship_application_id
                  LEFT JOIN answers ans ON ans.question_id = q.id AND ans.applicant_id = sa.applicant_id
                  WHERE sa.scholarship_application_id = ?
                  ORDER BY sa.id, q.id";
    
        $stmt = $this->db->prepare($query);
        $stmt->bindValue(1, $this->scholarship_application_id, PDO::PARAM_INT);
        $stmt->execute();
        $result = $stmt->fetchAll(PDO::FETCH_ASSOC);
    
        $applications = [];
        foreach ($result as $row) {
            $appId = $row['application_id'];
    
            if (!isset($applications[$appId])) {
                $applications[$appId] = [
                    "application_id" => $row["application_id"],
                    "status" => $row["status"],
                    "submitted_at" => $row["submitted_at"],
                    "application_name" => $row["application_name"],
                    "company" => $row["company"],
                    "application_description" => $row["application_description"],
                    "duration" => $row["duration"],
                    "application_image" => $row["application_image"],
                    "category" => $row["category"],
                    "slots" => $row["slots"],
                    "deadline" => $row["deadline"],
                    "applicant" => [
                        "id" => $row["applicant_id"],
                        "username" => $row["username"],
                        "email" => $row["email"],
                        "firstname" => $row["firstname"],
                        "lastname" => $row["lastname"],
                        "gender" => $row["gender"],
                        "birthdate" => $row["birthdate"],
                        "phone_number" => $row["phone_number"],
                        "school" => $row["school"],
                        "program" => $row["program"],
                        "rpc" => $row["rpc"],
                        "bsb" => $row["bsb"]
                    ],
                    "questions" => []
                ];
            }
            
            if (!empty($row["question"])) {
                $applications[$appId]["questions"][] = [
                    "question_id" => $row["question_id"],
                    "question" => $row["question"],
                    "answer" => $row["answer"]
                ];
            }
        }
    
        return array_values($applications);
    }

    public function getApplicantApplications($applicant_id) {
        if (is_array($applicant_id)) {
            $applicant_id = reset($applicant_id);
        }
        $applicant_id = (int) $applicant_id;
        
        $query = "SELECT 
                    sa.id AS application_id, sa.status, sa.submitted_at,
                    a.id AS applicant_id, a.username, a.email, a.firstname, a.lastname, a.gender,
                    a.birthdate, a.phone_number, a.school, a.program, a.rpc, a.bsb,
                    s.id AS scholarship_application_id, s.application_name AS application_name, 
                    s.company AS company, s.duration AS duration, s.category AS category,
                    s.application_image AS application_image, s.application_description AS application_description, 
                    s.slots AS slots, s.deadline,
                    q.id AS question_id, q.question,
                    ans.answer
                FROM applications sa
                JOIN applicants a ON sa.applicant_id = a.id
                JOIN scholarship_applications s ON sa.scholarship_application_id = s.id
                LEFT JOIN questions q ON q.scholarship_application_id = sa.scholarship_application_id
                LEFT JOIN answers ans ON ans.question_id = q.id AND ans.applicant_id = sa.applicant_id
                WHERE sa.applicant_id = ?
                ORDER BY sa.id, q.id";
    
        $stmt = $this->db->prepare($query);
        $stmt->bindValue(1, $applicant_id, PDO::PARAM_INT);
        $stmt->execute();
        $result = $stmt->fetchAll(PDO::FETCH_ASSOC);
    
        if (!$result) {
            return [];
        }
    
        $applications = [];
        
        foreach ($result as $row) {
            $app_id = $row["application_id"];
    
            if (!isset($applications[$app_id])) {
                $applications[$app_id] = [
                    "application_id" => $row["application_id"],
                    "status" => $row["status"],
                    "submitted_at" => $row["submitted_at"],
                    "application_name" => $row["application_name"],
                    "company" => $row["company"],
                    "application_description" => $row["application_description"],
                    "duration" => $row["duration"],
                    "application_image" => $row["application_image"],
                    "slots" => $row["slots"],
                    "deadline" => $row["deadline"],
                    "applicant" => [
                        "id" => $row["applicant_id"],
                        "username" => $row["username"],
                        "email" => $row["email"],
                        "firstname" => $row["firstname"],
                        "lastname" => $row["lastname"],
                        "gender" => $row["gender"],
                        "birthdate" => $row["birthdate"],
                        "phone_number" => $row["phone_number"],
                        "school" => $row["school"],
                        "program" => $row["program"],
                        "rpc" => $row["rpc"],
                        "bsb" => $row["bsb"]
                    ],
                    "questions" => []
                ];
            }
    
            if (!empty($row["question"])) {
                $applications[$app_id]["questions"][] = [
                    "question_id" => $row["question_id"],
                    "question" => $row["question"],
                    "answer" => $row["answer"]
                ];
            }
        }
    
        return array_values($applications);
    }    
    
    public function updateStatus() {
        $query = "UPDATE applications SET status = :status, updated_at = CURRENT_TIMESTAMP WHERE id = :id";
        $stmt = $this->db->prepare($query);
        $stmt->bindValue(":status", $this->status, PDO::PARAM_STR);
        $stmt->bindValue(":id", $this->id, PDO::PARAM_INT);

        if ($stmt->execute()) {
            $query = "SELECT s.application_name, a.applicant_id FROM applications a JOIN scholarship_applications s ON a.scholarship_application_id = s.id WHERE a.id = :id";
            $stmt = $this->db->prepare($query);
            $stmt->bindValue(":id", $this->id, PDO::PARAM_INT);
            $stmt->execute();
            $result = $stmt->fetch(PDO::FETCH_ASSOC);
            $application_name = $result['application_name'] ?? 'Application';
            $this->applicant_id = $result['applicant_id'] ?? null;

            $fcm_token = "fk5hIV-hStimrEUH2B5Tvr:APA91bGVWouQv4usHLK2rE0EnCAVuOyYVFBv_k2V6Cru4MlvzfOSiCmBWRBsksQxaRT7GLuvgAjq6Un5Yk068Di87vjtbKr05wdcLzfN0aDsX3YV3IW4WcM"; 

            if (!empty($fcm_token)) {
                $this->sendFCMNotification($fcm_token, $application_name);
            }
            return true;
        }
        return false;
    }

    private function sendFCMNotification($fcm_token, $application_name) {
        $accessToken = generateAccessToken();

        if (!$accessToken) {
            return "Error: Failed to generate access token.";
        }

        $url = "https://fcm.googleapis.com/v1/projects/scholarzone-d300c/messages:send";
        
        $headers = [
            "Authorization: Bearer " . $accessToken,
            "Content-Type: application/json"
        ];

        if ($this->status == 'Approved') {
            $body = "Congratulations! Your application has been approved.";
        } else if ($this->status == 'Rejected') {
            $body = "We regret to inform you that your application has been rejected.";
        } else {
            $body = "Your application status has been updated.";
        }

        $notification = [
            "message" => [
                "token" => $fcm_token,
                "notification" => [
                    "title" => "{$application_name} Application Status",
                    "body" => $body
                ],
                "data" => [
                    "application_id" => (string) $this->id,
                    "status" => (string) $this->status
                ]
            ]
        ];

        $ch = curl_init();
        curl_setopt($ch, CURLOPT_URL, $url);
        curl_setopt($ch, CURLOPT_POST, true);
        curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($notification));
        
        $response = curl_exec($ch);
        $httpCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);
        $curlError = curl_error($ch);
        curl_close($ch);

        if ($curlError) {
            return "cURL Error: " . $curlError;
        }

        $this->storeNotification($this->applicant_id, "{$application_name} Application Status", $body);

        return "HTTP Code: $httpCode\nResponse: $response";
    }

    public function getNotifications($applicantId) {
        $query = "SELECT * FROM applicant_notifications WHERE applicant_id = :applicant_id";
        $stmt = $this->db->prepare($query);
        $stmt->bindParam(':applicant_id', $applicantId);
        $stmt->execute();

        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    private function storeNotification($applicant_id, $title, $body) {
        $query = "INSERT INTO applicant_notifications (applicant_id, title, body) VALUES (:applicant_id, :title, :body)";
        $stmt = $this->db->prepare($query);
        $stmt->bindValue(":applicant_id", $applicant_id, PDO::PARAM_INT);
        $stmt->bindValue(":title", $title, PDO::PARAM_STR);
        $stmt->bindValue(":body", $body, PDO::PARAM_STR);
        $stmt->execute();
    }
}
?>
