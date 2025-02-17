<?php

require_once 'controllers/ApplicantController.php';
require_once 'config/Database.php';
require_once 'controllers/ReviewerController.php';
require_once 'controllers/ScholarshipApplicationController.php';

$db = (new Database())->connect();
$applicantController = new ApplicantController($db);
$scholarshipApplicationController = new ScholarshipApplicationController($db);
$reviewerController = new ReviewerController($db);

// Applicant Sign Up
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_GET['route']) && $_GET['route'] === 'applicants') {
    $contentType = $_SERVER['CONTENT_TYPE'] ?? '';

    if (stripos($contentType, 'application/json') !== false) {
        $input = json_decode(file_get_contents("php://input"), true);
    } elseif (stripos($contentType, 'application/x-www-form-urlencoded') !== false) {
        $input = $_POST;
    } else {
        echo json_encode([
            "status" => 400,
            "message" => "Invalid Content-Type. Use application/json or application/x-www-form-urlencoded."
        ]);
        exit;
    }

    if (!$input) {
        echo json_encode([
            "status" => 400,
            "message" => "Invalid input or malformed JSON."
        ]);
        exit;
    }

    $requiredFields = [
        'username', 'email', 'password', 'firstname', 'lastname', 
        'gender', 'birthdate', 'phone_number', 'school', 
        'program', 'rpc', 'bsb'
    ];

    $missingFields = [];
    foreach ($requiredFields as $field) {
        if (empty($input[$field])) {
            $missingFields[] = $field;
        }
    }

    if (!empty($missingFields)) {
        echo json_encode([
            "status" => 400,
            "message" => "Missing required fields: " . implode(', ', $missingFields)
        ]);
        exit;
    }

    $response = $applicantController->signUp($input);
    http_response_code($response['status']);
    echo json_encode($response);
    exit;
}

// Reviewer Sign Up
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_GET['route']) && $_GET['route'] === 'reviewers') {
    $contentType = $_SERVER['CONTENT_TYPE'] ?? '';

    if (stripos($contentType, 'application/json') !== false) {
        $input = json_decode(file_get_contents("php://input"), true);
    } elseif (stripos($contentType, 'application/x-www-form-urlencoded') !== false) {
        $input = $_POST;
    } else {
        echo json_encode([
            "status" => 400,
            "message" => "Invalid Content-Type. Use application/json or application/x-www-form-urlencoded."
        ]);
        exit;
    }

    if (!$input) {
        echo json_encode([
            "status" => 400,
            "message" => "Invalid input or malformed JSON."
        ]);
        exit;
    }

    $requiredFields = [
        'username', 'email', 'password', 'firstname', 'lastname', 'gender', 'birthdate', 'phone_number', 'company', 'rpc', 'bsb'
    ];

    $missingFields = [];
    foreach ($requiredFields as $field) {
        if (empty($input[$field])) {
            $missingFields[] = $field;
        }
    }

    // If any required fields are missing, return an error
    if (!empty($missingFields)) {
        echo json_encode([
            "status" => 400,
            "message" => "Missing required fields: " . implode(', ', $missingFields)
        ]);
        exit;
    }

    $response = $reviewerController->signUp($input);
    http_response_code($response['status']);
    echo json_encode($response);
    exit;
}


// Applicant Log in
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_GET['route']) && $_GET['route'] === 'applicant-login') {
    $contentType = $_SERVER['CONTENT_TYPE'] ?? '';

    if (stripos($contentType, 'application/json') !== false) {
        $input = json_decode(file_get_contents("php://input"), true);
    } elseif (stripos($contentType, 'application/x-www-form-urlencoded') !== false) {
        $input = $_POST;
    } else {
        echo json_encode([
            "status" => 400,
            "message" => "Invalid Content-Type. Use application/json or application/x-www-form-urlencoded."
        ]);
        exit;
    }

    if (empty($input['email']) || empty($input['password'])) {
        echo json_encode([
            "status" => 400,
            "message" => "Email and password are required."
        ]);
        exit;
    }

    $response = $applicantController->login($input['email'], $input['password']);
    http_response_code($response['status']);
    echo json_encode($response);
    exit;
}

// Reviewer Log in
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_GET['route']) && $_GET['route'] === 'reviewer-login') {
    $contentType = $_SERVER['CONTENT_TYPE'] ?? '';

    if (stripos($contentType, 'application/json') !== false) {
        $input = json_decode(file_get_contents("php://input"), true);
    } elseif (stripos($contentType, 'application/x-www-form-urlencoded') !== false) {
        $input = $_POST;
    } else {
        echo json_encode([
            "status" => 400,
            "message" => "Invalid Content-Type. Use application/json or application/x-www-form-urlencoded."
        ]);
        exit;
    }

    if (empty($input['email']) || empty($input['password'])) {
        echo json_encode([
            "status" => 400,
            "message" => "Email and password are required."
        ]);
        exit;
    }

    $response = $reviewerController->login($input['email'], $input['password']);
    http_response_code($response['status']);
    echo json_encode($response);
    exit;
}


/*
    SCHOLARSHIP APPLICATION ROUTES
*/

// Scholarship Create
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_GET['route']) && $_GET['route'] === 'scholarship-create') {
    $contentType = $_SERVER['CONTENT_TYPE'] ?? '';

    if (stripos($contentType, 'application/json') !== false) {
        $input = json_decode(file_get_contents("php://input"), true);
    } elseif (stripos($contentType, 'application/x-www-form-urlencoded') !== false) {
        $input = $_POST;
    } else {
        echo json_encode([
            "status" => 400,
            "message" => "Invalid Content-Type. Use application/json or application/x-www-form-urlencoded."
        ]);
        exit;
    }

    if (!$input) {
        echo json_encode([
            "status" => 400,
            "message" => "Invalid input or malformed JSON."
        ]);
        exit;
    }

    if (empty($input['application_name']) || empty($input['application_description']) || empty($input['duration']) || empty($input['category']) || empty($input['slots']) || empty($input['deadline'])) {
        echo json_encode([
            "status" => 400,
            "message" => "Missing required fields."
        ]);
        exit;
    }

    $token = $_SERVER['HTTP_AUTHORIZATION'] ?? '';
    if (strpos($token, 'Bearer ') !== false) {
        $token = str_replace('Bearer ', '', $token);
    } else {
        echo json_encode([
            "status" => 400,
            "message" => "Authorization token missing or invalid. Ensure the token starts with 'Bearer '."
        ]);
        exit;
    }

    error_log("Received Token: " . $token);
    $response = $scholarshipApplicationController->createApplication($input, $token);
    http_response_code($response['status']);
    echo json_encode($response);
    exit;
}

// Get All Scholarship Applications
if ($_SERVER['REQUEST_METHOD'] === 'GET' && isset($_GET['route']) && $_GET['route'] === 'scholarships') {
    $response = $scholarshipApplicationController->getAllApplications();
    http_response_code($response['status']);
    echo json_encode($response);
    exit;
}

// Get Scholarship Applications for the Reviewer
if ($_SERVER['REQUEST_METHOD'] === 'GET' && isset($_GET['route']) && $_GET['route'] === 'reviewer-scholarships') {
    $token = $_SERVER['HTTP_AUTHORIZATION'] ?? '';
    if (strpos($token, 'Bearer ') !== false) {
        $token = str_replace('Bearer ', '', $token);
    } else {
        echo json_encode([
            "status" => 400,
            "message" => "Authorization token missing or invalid. Ensure the token starts with 'Bearer '."
        ]);
        exit;
    }

    error_log("Received Token: " . $token);

    $response = $scholarshipApplicationController->getReviewerApplications($token);
    http_response_code($response['status']);
    echo json_encode($response);
    exit;
}

// Update Scholarship Application
if ($_SERVER['REQUEST_METHOD'] === 'PUT' && isset($_GET['route']) && $_GET['route'] === 'scholarship-update') {
    $contentType = $_SERVER['CONTENT_TYPE'] ?? '';

    if (stripos($contentType, 'application/json') !== false) {
        $input = json_decode(file_get_contents("php://input"), true);
    } elseif (stripos($contentType, 'application/x-www-form-urlencoded') !== false) {
        $input = $_POST;
    } else {
        echo json_encode([
            "status" => 400,
            "message" => "Invalid Content-Type. Use application/json or application/x-www-form-urlencoded."
        ]);
        exit;
    }

    error_log('Raw Input: ' . file_get_contents("php://input"));

    if (!$input) {
        echo json_encode([
            "status" => 400,
            "message" => "Invalid input or malformed JSON."
        ]);
        exit;
    }

    if (empty($input['id']) || empty($input['application_name']) || empty($input['application_description']) || empty($input['duration']) || empty($input['category']) || empty($input['slots']) || empty($input['deadline'])) {
        echo json_encode([
            "status" => 400,
            "message" => "Missing required fields."
        ]);
        exit;
    }

    $token = $_SERVER['HTTP_AUTHORIZATION'] ?? '';
    if (strpos($token, 'Bearer ') !== false) {
        $token = str_replace('Bearer ', '', $token);  // Remove "Bearer " prefix
    } else {
        echo json_encode([
            "status" => 400,
            "message" => "Authorization token missing or invalid. Ensure the token starts with 'Bearer '."
        ]);
        exit;
    }

    $response = $scholarshipApplicationController->updateApplication($input, $token);
    http_response_code($response['status']);
    echo json_encode($response);
    exit;
}

// Delete Scholarship Application
if ($_SERVER['REQUEST_METHOD'] === 'DELETE' && isset($_GET['route']) && $_GET['route'] === 'scholarship-delete') {
    $id = $_GET['id'] ?? null;

    if (!$id) {
        echo json_encode([
            "status" => 400,
            "message" => "Scholarship ID is required."
        ]);
        exit;
    }

    $token = $_SERVER['HTTP_AUTHORIZATION'] ?? '';
    if (strpos($token, 'Bearer ') !== false) {
        $token = str_replace('Bearer ', '', $token);
    } else {
        echo json_encode([
            "status" => 400,
            "message" => "Authorization token missing or invalid. Ensure the token starts with 'Bearer '."
        ]);
        exit;
    }

    $response = $scholarshipApplicationController->deleteApplication($id, $token);
    http_response_code($response['status']);
    echo json_encode($response);
    exit;
}

echo json_encode([
    "status" => 404,
    "message" => "Route not found or invalid request method."
]);
exit;

?>
