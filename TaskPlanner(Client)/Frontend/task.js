
let itemsDetails = class {
    adminInput(a, b, c, d, e, f, g, h, i) {
        this.type = a;
        this.title = b;
        this.description = c;
        this.status = d;
        this.assignee = e;
        this.priority = f;
        this.estimatedTime = g;
        this.actualTime = h;
        this.dueDate = i;


    }
}

let addItems = async () => {

    let task_type = document.querySelector('#type').value;
    let task_title = document.querySelector('#title').value;
    let description = document.querySelector('#description').value;
    let status = document.querySelector('#status').value;
    let assignee = document.querySelector('#assignee').value;
    let priority = document.querySelector('#priority').value;

    let estimatedTime = document.querySelector('#estimatedTime').value;
    let actualTime = document.querySelector('#actualTime').value;
    let dueDate = document.querySelector('#dueDate').value;

    let data = new itemsDetails();
    data.adminInput(task_type, task_title, description, status, assignee, priority, estimatedTime, actualTime, dueDate)

    let stringy_data = JSON.stringify(data)
    // console.log(stringy_data)

    let url = `http://localhost:8081/tasks/createTask`;

    let response = await fetch(url, { method: 'POST', body: stringy_data, headers: { 'Content-Type': 'application/json' } });

    let Data = await response.json();

    console.log(Data)

}


