

let getItems = async () => {

    let url = `https://taskplannerapi.onrender.com/tasks/getAllTasks`;

    let res = await fetch(url);

    let data = await res.json();
    console.log(data);

    Append(data);

}
getItems();

let Append = (array) => {
    console.log(array)

    let Container = document.querySelector('#added-items');
    Container.innerHTML = null;

    array.forEach(element => {
        let box = document.createElement('div');
        box.setAttribute("id", "box")

        let actualTime = document.createElement('h3');
        let assignee = document.createElement('h3');
        let description = document.createElement('h4');
        let dueDate = document.createElement('h3');
        let estimatedTime = document.createElement('h3');
        let id = document.createElement('h3');
        let priority = document.createElement('h3');
        let status = document.createElement('h3');
        let title = document.createElement('h3');
        let type = document.createElement('h3');


        actualTime.textContent = "Actual Time: " + element.actualTime + " Days";
        assignee.textContent = "Assign to: " + element.assignee;
        description.textContent = "Task Description: " + element.description;
        dueDate.textContent = "Due Date: " + element.dueDate;
        estimatedTime.textContent = "Estimate Time: " + element.estimatedTime;
        id.textContent = "Task ID: " + element.id;
        priority.textContent = "Priority: " + element.priority;
        status.textContent = "Task Status: " + element.status;
        title.textContent = "Task Title: " + element.title;
        type.textContent = "Type of Task: " + element.type;



        box.append(actualTime, assignee, description, dueDate, estimatedTime, id, priority, status, title, type);

        Container.append(box)

    });

}


let filterbyPriority = async () => {

    let name = document.querySelector("#priority-filter").value;

    let url = `https://taskplannerapi.onrender.com/tasks/filterByPriority/${name}`;

    let res = await fetch(url);

    let data = await res.json();

    console.log(data);

    Append(data)

}

let filterbyStatus = async () => {

    let name = document.querySelector("#status-filter").value;

    let url = `https://taskplannerapi.onrender.com/tasks/filterByStatus/${name}`;

    let res = await fetch(url);

    let data = await res.json();

    console.log(data);

    Append(data)

}


