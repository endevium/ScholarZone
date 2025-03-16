// Import the functions you need from the SDKs you need
const firebaseConfig = {
    apiKey: "AIzaSyBNNbX2MRKYykb1UVe_2VMM7KCtTWh8Sbg",
    authDomain: "scholarzone-d300c.firebaseapp.com",
    projectId: "scholarzone-d300c",
    storageBucket: "scholarzone-d300c.firebasestorage.app",
    messagingSenderId: "404455938653",
    appId: "1:404455938653:web:78edf85dae614481ba0bb4",
    measurementId: "G-LG9252T1HT"
};

// Initialize Firebase
firebase.initializeApp(firebaseConfig);

// Get Firebase Messaging instance
const messaging = firebase.messaging();
