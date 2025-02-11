<?php

require_once 'controllers/UserController.php';
require_once 'config/Database.php';
require_once 'controllers/ReviewerController.php';

// Initialize database and controller
$db = (new Database())->connect();
$userController = new UserController($db);
$reviewerController = new ReviewerController($db);

// Check the request method and route
if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_GET['route']) && $_GET['route'] === 'applicants') {
    $contentType = $_SERVER['CONTENT_TYPE'] ?? '';

    // Parse JSON or form-data
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

    // Debug received data
    if (!$input) {
        echo json_encode([
            "status" => 400,
            "message" => "Invalid input or malformed JSON."
        ]);
        exit;
    }

    // Check for required fields
    $requiredFields = [
        'username', 'email', 'password', 'firstname', 'lastname', 
        'gender', 'birthdate', 'phone_number', 'school', 
        'program', 'full_address', 'rpc', 'bsb'
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

    // Pass input to the controller
    $response = $userController->signUp($input);
    http_response_code($response['status']);
    echo json_encode($response);
    exit;
}

if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_GET['route']) && $_GET['route'] === 'reviewers') {
    $contentType = $_SERVER['CONTENT_TYPE'] ?? '';

    // Parse JSON or form-data
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

    // Debug received data
    if (!$input) {
        echo json_encode([
            "status" => 400,
            "message" => "Invalid input or malformed JSON."
        ]);
        exit;
    }

    // Check for required fields
    $requiredFields = [
        'username', 'email', 'password', 'firstname', 'lastname', 'gender', 'birthdate', 'phone_number', 'company', 'full_address', 'rpc', 'bsb'
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

if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_GET['route']) && $_GET['route'] === 'applicant-login') {
    $contentType = $_SERVER['CONTENT_TYPE'] ?? '';

    // Parse JSON or form-data
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

    // Validate input
    if (empty($input['email']) || empty($input['password'])) {
        echo json_encode([
            "status" => 400,
            "message" => "Email and password are required."
        ]);
        exit;
    }

    // Pass to login method in UserController
    $response = $userController->login($input['email'], $input['password']);
    http_response_code($response['status']);
    echo json_encode($response);
    exit;
}


if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_GET['route']) && $_GET['route'] === 'reviewer-login') {
    $contentType = $_SERVER['CONTENT_TYPE'] ?? '';

    // Parse JSON or form-data
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

    // Validate input
    if (empty($input['email']) || empty($input['password'])) {
        echo json_encode([
            "status" => 400,
            "message" => "Email and password are required."
        ]);
        exit;
    }

    // Pass to login method in UserController
    $response = $reviewerController->login($input['email'], $input['password']);
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
