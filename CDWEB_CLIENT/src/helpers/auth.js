export default function authHeader() {
  const user = JSON.parse(localStorage.getItem('user'));
  if (user && user.accessToken) {
    return { 'bearer-token': user.accessToken };
  } else {
    return {};
  }
}