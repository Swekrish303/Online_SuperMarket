const submitInput = document.querySelector("submitInput");
const emailInput = document.getElementById("email");
const passwordInput = document.getElementById("password");
const form = document.querySelector('form');
submitInput.addEventListener("click", () => {
    const email = emailInput.value;
    const password = passwordInput.value;
    
    
  
    axios.post("localhost:8080/user/signup", {
        
        email: email,
        password: password
      })
      .then((response) => {
        console.log(response);
      });
  });