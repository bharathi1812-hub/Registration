function register(event) {
    event.preventDefault();

    const username = document.getElementById("username").value.trim();
    const password = document.getElementById("password").value.trim();
    const msg = document.getElementById("msg");
    const btn = document.getElementById("btn");

    document.getElementById("userError").innerText = "";
    document.getElementById("passError").innerText = "";
    msg.innerText = "";

    if (username.length < 3) {
        document.getElementById("userError").innerText =
            "Username must be at least 3 characters";
        return;
    }

    if (password.length < 4) {
        document.getElementById("passError").innerText =
            "Password must be at least 4 characters";
        return;
    }

    btn.innerText = "Registering...";
    btn.disabled = true;

    fetch("http://localhost:8080/register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username, password })
    })
    .then(async res => {
        if (!res.ok) {
            const err = await res.text();
            throw new Error(err);
        }
        return res.json();
    })
    .then(() => {
        msg.style.color = "green";
        msg.innerText = "🎉 Registration successful!";
        document.getElementById("username").value = "";
        document.getElementById("password").value = "";
    })
    .catch(err => {
        msg.style.color = "red";
        msg.innerText = err.message || "Registration failed";
    })
    .finally(() => {
        btn.innerText = "Register";
        btn.disabled = false;
    });
}
