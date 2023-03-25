

let getItems = async() =>{

    let url = `http://127.0.0.1:3000/api/items`;

    let res = await fetch(url);

    let data = await res.json();
    //console.log(data);

    Append(data);

}
getItems();


let Append = (array)=>{
    console.log(array)

    let Container = document.querySelector('#added-items');
    Container.innerHTML = null;

    array.forEach(element => {
        let box = document.createElement('div');
        box.setAttribute("id", "box")
        
        let box1 = document.createElement('div');
        box1.setAttribute("id", "box1")
        let box2 = document.createElement('div');
        box2.setAttribute("id", "box2")
        let box3 = document.createElement('div');
        box3.setAttribute("id", "box3")

        let IMG = document.createElement('img');
        let TIT = document.createElement('h3');
        let PRI = document.createElement('h4');
        let RAT = document.createElement('P');
        let DES = document.createElement('P');

        IMG.src = element.image;
        TIT.textContent = element.title;
        PRI.textContent = "Rs. "+ element.price;
        RAT.textContent = "Rating: "+ element.rating+"/10";
        DES.textContent = "Description: "+ element.description;

        box1.append(IMG);
        box2.append(TIT,PRI,DES);
        box3.append(RAT);
        box.append(box1,box2,box3);

        Container.append(box)

    });

}



// sorting - filtering


let sortbyPrice = async () =>{

    let url = `http://127.0.0.1:3000/api/items/?_sort=price&_order=asc`;

    let res = await fetch(url);

    let data = await res.json();

    console.log(data);

    Append(data)

}

let filterbyRating = async () =>{

    let url = `http://127.0.0.1:3000/api/items/?rating_gte=4`;

    let res = await fetch(url);

    let data = await res.json();

    console.log(data);

    Append(data)

}


