function myFunction(){
    let myParent = document.getElementById("prerequisitesDiv");
    fetch("http://localhost:8082/AcademiaERP_Project_war/api/course/getCourses", {
        // Adding method type
        method: "get",
        // Adding headers to the request
        headers: {
            "Content-type": "application/json; charset=UTF-8",
        },
    })// Converting to JSON
        .then((response) => response.json())

        // Displaying results to console
        .then((json) => {
            console.log(json)
            let list = json;
            let array = [];
            for(let i=0;i<list.length;i++){
                array.push(list[i].course_id);
            }
            let selectList = document.createElement("select");
            selectList.id = "prerequisites";
            selectList.multiple = true;
            selectList.type = "radio";
            myParent.appendChild(selectList);
            for (let i = 0; i < array.length; i++) {
                let option = document.createElement("option");
                option.value = array[i];
                option.text = array[i];
                selectList.appendChild(option);
            }
        });
}

function loginCheck(){
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;
    console.log(email);
    console.log(password);

    let creds = {
        emailId: email,
        password: password,
        firstName : null,
        lastName : null,
        location : null,
        department : null
    };
    fetch("http://localhost:8082/AcademiaERP_Project_war/api/login/verify", {
        // Adding method type
        method: "POST",
        // Adding body or contents to send
        body: JSON.stringify(creds),
        // Adding headers to the request
        headers: {
            "Content-type": "application/json; charset=UTF-8",
        },
    })// Converting to JSON
        .then((response) => {
          alert('Result Recieved')
          if(response.status == 200){
              location.href = 'coursePage.html';
          }
          else{
              alert("Login Failed!!! Please Check")
          }
        })

        // Displaying results to console
        // .then((json) => {
        //     // Popup
        // }
        //);
    alert("Your request is in processing....")
}

function submitFunction() {
    // Getting values
    let name = document.getElementById("name").value;
    let professor = document.getElementById("profName").value;
    let specialization = document.getElementById("specialization").value;
    let credits = document.getElementById("credits").value;
    let capacity = document.getElementById("capacity").value;
    let schedule = document.getElementById("schedule").value;

    //Create an Array.
    let selected = [];
    for (let option of document.getElementById('prerequisites').options)
    {
        if (option.selected) {
            selected.push({course_id : option.value});
        }
    }
    alert(selected);
    let obj = {
        name: name,
        professor: professor,
        specialization: specialization,
        capacity: capacity,
        credits: credits,
        schedule: schedule,
        prerequisites : selected
    };

    // Send to Backend
    fetch("http://localhost:8082/AcademiaERP_Project_war/api/course/add", {
        // Adding method type
        method: "POST",
        // Adding body or contents to send
        body: JSON.stringify(obj),
        // Adding headers to the request
        headers: {
            "Content-type": "application/json; charset=UTF-8",
        },
    })
    // Converting to JSON
        .then((response) => {
            if(response.status == 200){
                alert('Successfully Added the course !!')
            }
            else{
                alert("Operation Failed!!! Please Check the entries")
            }
        })
    alert("Your request is in processing....")


}