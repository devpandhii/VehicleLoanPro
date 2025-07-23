// Initialize demo user on page load
document.addEventListener("DOMContentLoaded", () => {
  const users = JSON.parse(localStorage.getItem("users")) || [];

  const demoExists = users.some(u => u.email === "demo@vehicleloan.com");

  if (!demoExists) {
    users.push({
      id: "demo123",
      name: "Demo User",
      email: "demo@vehicleloan.com",
      password: "demo123",
      phone: "9876543210",
      address: "Mumbai"
    });
    localStorage.setItem("users", JSON.stringify(users));
  }
});

/**
 * Login Function
 */
function login() {
  const email = document.getElementById("email")?.value.trim();
  const password = document.getElementById("password")?.value.trim();

  if (!email || !password) {
    alert("Please enter both email and password.");
    return false;
  }

  const users = JSON.parse(localStorage.getItem("users")) || [];
  const user = users.find(u => u.email === email && u.password === password);

  if (user) {
    localStorage.setItem("loggedInUser", JSON.stringify(user)); // store user in session
    alert("Login successful!");
    window.location.href = "dashboard.html"; // redirect after login
  } else {
    alert("Invalid email or password!");
  }

  return false;
}

/**
 * Signup Function
 */
function signup() {
  const name = document.getElementById("name")?.value.trim();
  const email = document.getElementById("email")?.value.trim();
  const phone = document.getElementById("phone")?.value.trim();
  const password = document.getElementById("password")?.value.trim();
  const address = document.getElementById("address")?.value.trim();

  if (!name || !email || !phone || !password || !address) {
    alert("All fields are required.");
    return false;
  }

  const users = JSON.parse(localStorage.getItem("users")) || [];

  const userExists = users.some(u => u.email === email);

  if (userExists) {
    alert("Email already registered!");
    return false;
  }

  const newUser = {
    id: "user" + Date.now(),
    name,
    email,
    phone,
    password,
    address
  };

  users.push(newUser);
  localStorage.setItem("users", JSON.stringify(users));

  alert("Signup successful! Please login.");
  window.location.href = "login.html";
  return false;
}
