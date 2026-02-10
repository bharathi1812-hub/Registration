function register() {
    const username = document.getElementById("username").value.trim();
    const password = document.getElementById("password").value.trim();
    const msg = document.getElementById("msg");

    if (!username || !password) {
        alert("Username and password required!");
        return;
    }

    fetch("http://localhost:8080/register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username, password })
    })
    .then(async response => {
        if (!response.ok) {
            const error = await response.text();
            throw new Error(error);
        }
        return response.json();
    })
    .then(data => {
        alert("Registered successfully!");
    })
    .catch(err => {
        alert(err.message);   // 👈 shows backend message
    });
}
