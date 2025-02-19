<?php

require_once 'controllers/ApplicantController.php';
require_once 'config/Database.php';
require_once 'controllers/ReviewerController.php';
require_once 'controllers/ScholarshipApplicationController.php';
require_once 'controllers/QuestionController.php';
require_once 'controllers/AnswerController.php';

$db = (new Database())->connect();
$applicantController = new ApplicantController($db);
$scholarshipApplicationController = new ScholarshipApplicationController($db);
$reviewerController = new ReviewerController($db);
$questionController = new QuestionController($db);

/*
    APPLICANT & REVIEWER
    POST METHODS
*/

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
    APPLICANT & REVIEWER
    GET METHODS
*/

if ($_SERVER['REQUEST_METHOD'] === 'GET' && isset($_GET['route']) && $_GET['route'] === 'applicants') {
    $id = $_GET['id'] ?? null;

    if (!$id) {
        echo json_encode([
            "status" => 400,
            "message" => "Applicant ID is required."
        ]);
        exit;
    }

    $response = $applicantController->getApplicantById($id);
    http_response_code($response['status']);
    echo json_encode($response);
    exit;
}

if ($_SERVER['REQUEST_METHOD'] === 'GET' && isset($_GET['route']) && $_GET['route'] === 'reviewers') {
    $id = $_GET['id'] ?? null;

    if (!$id) {
        echo json_encode([
            "status" => 400,
            "message" => "Reviewer ID is required."
        ]);
        exit;
    }

    $response = $reviewerController->getReviewerById($id);
    http_response_code($response['status']);
    echo json_encode($response);
    exit;
}

/* 
    APPLICANT & REVIEWER
    UPDATE PROFILE
*/

if ($_SERVER['REQUEST_METHOD'] === 'PUT' && $_GET['route'] === 'update-applicant') {
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

    $controller = new ApplicantController($db);
    $response = $controller->updateProfile($token, $input);
    echo json_encode($response);
    exit;
}


if ($_SERVER['REQUEST_METHOD'] === 'PUT' && $_GET['route'] === 'update-reviewer') {
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

    $controller = new ReviewerController($db);
    $response = $controller->updateProfile($token, $input);
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

    if (empty($input['application_name']) || empty($input['company']) || empty($input['application_description']) || empty($input['duration']) || empty($input['category']) || empty($input['slots']) || empty($input['deadline'])) {
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
    echo json_encode($response);
    exit;
}

// Search Scholarship Applications
if ($_SERVER['REQUEST_METHOD'] === 'GET' && isset($_GET['route']) && $_GET['route'] === 'search-scholarships') {
    $keyword = isset($_GET['search']) ? $_GET['search'] : null;

    if (!$keyword) {
        echo json_encode([
            "status" => 400,
            "message" => "Search keyword is required."
        ]);
        exit;
    }

    $response = $scholarshipApplicationController->searchApplications($keyword);
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

    if (!$input) {
        echo json_encode([
            "status" => 400,
            "message" => "Invalid input or malformed JSON."
        ]);
        exit;
    }

    if (empty($input['id']) || empty($input['application_name']) || empty($input['company']) || empty($input['application_description']) || empty($input['duration']) || empty($input['category']) || empty($input['slots']) || empty($input['deadline'])) {
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


/*
    QUESTIONS
*/

// Create a question
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_GET['route']) && $_GET['route'] === 'question-create') {
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

    if (empty($input['scholarship_application_id']) || empty($input['question'])) {
        echo json_encode([
            "status" => 400,
            "message" => "Missing required field: question"
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

    $questionController = new QuestionController($db);
    $response = $questionController->createQuestion($input, $token);

    http_response_code($response['status']);
    echo json_encode($response);
    exit;
}

// Get all questions
if ($_SERVER['REQUEST_METHOD'] === 'GET' && isset($_GET['route']) && $_GET['route'] === 'questions') {
    $scholarship_application_id = $_GET['scholarship_application_id'] ?? null;

    if (!$scholarship_application_id) {
        echo json_encode([
            "status" => 400,
            "message" => "Missing scholarship_application_id."
        ]);
        exit;
    }

    $questionController = new QuestionController($db);
    $response = $questionController->getAllQuestions($scholarship_application_id);

    http_response_code($response['status']);
    echo json_encode($response);
    exit;
}

// Update a question
if ($_SERVER['REQUEST_METHOD'] === 'PUT' && isset($_GET['route']) && $_GET['route'] === 'question-update') {
    $id = $_GET['id'] ?? null;

    if (!$id) {
        echo json_encode([
            "status" => 400,
            "message" => "Question ID is required."
        ]);
        exit;
    }

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

    if (empty($input['scholarship_application_id']) || empty($input['question'])) {
        echo json_encode([
            "status" => 400,
            "message" => "Missing required fields: scholarship_application_id, and question."
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

    $questionController = new QuestionController($db);
    $response = $questionController->updateQuestion($id, $input, $token);

    http_response_code($response['status']);
    echo json_encode($response);
    exit;
}

// Delete a question
if ($_SERVER['REQUEST_METHOD'] === 'DELETE' && isset($_GET['route']) && $_GET['route'] === 'question-delete') {
    $id = $_GET['id'] ?? null;

    if (!$id) {
        echo json_encode([
            "status" => 400,
            "message" => "Question ID is required."
        ]);
        exit;
    }

    $input = json_decode(file_get_contents("php://input"), true);

    if (empty($input['scholarship_application_id'])) {
        echo json_encode([
            "status" => 400,
            "message" => "Missing scholarship application ID."
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

    $questionController = new QuestionController($db);
    $response = $questionController->deleteQuestion($id,$input, $token);

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
