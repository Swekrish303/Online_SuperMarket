const submitInput = document.getElementById("userSubmit")
const nameInput = document.getElementById("name");
const mobileInput = document.getElementById("mobile");

const emailInput = document.getElementById("email");
const passwordInput = document.getElementById("password");
submitInput.addEventListener("click", () => {
    document.getElementById("name").innerHTML = "created User"
    const email = emailInput.value;
    const password = passwordInput.value;
    const mobile = mobileInput.value;
    const name = nameInput.value 
    console.log(email, password, mobile, name)
    axios.post("http://localhost:8080/signup", {
        
        email: email,
        password: password,
        mobile: toString(mobile),
        name: name
      })
      .then((response) => {
          console.log(response);
          alert(response.data)
      })
      .catch(err => alert("backend error"));
  });
