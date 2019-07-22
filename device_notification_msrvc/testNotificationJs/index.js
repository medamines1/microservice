  navigator.serviceWorker.addEventListener('message', event => {
    if (event.data === 'newData') {
      showData();
    }
  });

  const registration = await navigator.serviceWorker.register('/sw.js');
  await navigator.serviceWorker.ready;  
  firebase.initializeApp({
      messagingSenderId: "544834184896"
  });
  const messaging = firebase.messaging();
  messaging.usePublicVapidKey('BGp0m04Ampbr2NBwX-ihnwartM9zbIUlS3Li7kFMKr5KF9JOkpPg5K4QHc8jgfpnV7P9t30BMsu1NqxtRfB5HEU');
  messaging.useServiceWorker(registration);  
  
  try {
    await messaging.requestPermission();
  } catch (e) {
    console.log('Unable to get permission', e);
    return;
  }
  const currentToken = await messaging.getToken();
  fetch('/register', { method: 'post', body: currentToken });
  showData();

  messaging.onTokenRefresh(async () => {
    console.log('token refreshed');
    const newToken = await messaging.getToken();
    fetch('/register', { method: 'post', body: currentToken });
  });
