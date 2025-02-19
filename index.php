<?php

header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET, POST, OPTIONS");
header("Access-Control-Allow-Headers: Content-Type, Authorization");
header("Content-Type: application/json; charset=UTF-8");

// Debugging: Print the route to check if .htaccess is working
$route = $_GET['route'] ?? '';

if (empty($route)) {
    echo json_encode([
        "status" => 400,
        "message" => "No route provided. Check .htaccess configuration."
    ]);
    exit;
}

require_once 'api/routes.php';

?>
