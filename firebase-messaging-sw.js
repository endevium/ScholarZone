importScripts("https://www.gstatic.com/firebasejs/10.9.0/firebase-app-compat.js");
importScripts("https://www.gstatic.com/firebasejs/10.9.0/firebase-messaging-compat.js");

// Initialize the Firebase app in the service worker by passing in the messagingSenderId.
firebase.initializeApp({
    apiKey: "AIzaSyBNNbX2MRKYykb1UVe_2VMM7KCtTWh8Sbg",
    authDomain: "scholarzone-d300c.firebaseapp.com",
    projectId: "scholarzone-d300c",
    storageBucket: "scholarzone-d300c.appspot.com",
    messagingSenderId: "404455938653",
    appId: "1:404455938653:web:78edf85dae614481ba0bb4",
    measurementId: "G-LG9252T1HT"
});

const messaging = firebase.messaging();

messaging.onBackgroundMessage((payload) => {
    console.log('[firebase-messaging-sw.js] Received background message ', payload);
    const notificationTitle = payload.notification.title;
    const notificationOptions = {
        body: payload.notification.body,
        icon: '/firebase-logo.png'
    };

    self.registration.showNotification(notificationTitle, notificationOptions);
});
