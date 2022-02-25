/*
    This code will use your servlets to render reimbursement date.
    You should not change the contents of this file.
*/

function renderTable(reimbursements) {
    const tbody = document.getElementById("r-table-body");

    if (!reimbursements) {
        tbody.innerHTML = "nothing to show"
    } else {
        tbody.innerHTML = "";
        for (let reimbursement of reimbursements) {
            const newRow = document.createElement("tr");
            tbody.appendChild(newRow);

            const idCell = document.createElement("td");
            newRow.appendChild(idCell);
            idCell.innerHTML = reimbursement.id;

            const descriptionCell = document.createElement("td");
            newRow.appendChild(descriptionCell);
            descriptionCell.innerHTML = reimbursement.description;

            const amountCell = document.createElement("td");
            newRow.appendChild(amountCell);
            amountCell.innerHTML = "$" + reimbursement.amount.toFixed(2);

            const dateCell = document.createElement("td");
            newRow.appendChild(dateCell);
            const dateArray = reimbursement.date;
            dateCell.innerHTML = `${dateArray[1]}/${dateArray[2]}/${dateArray[0]}`

            const statusCell = document.createElement("td");
            newRow.appendChild(statusCell);
            statusCell.innerHTML = reimbursement.status;
            const formatClasses = { PENDING: "bg-info", APPROVED: "bg-success", DENIED: "bg-danger" };
            statusCell.classList.add(formatClasses[reimbursement.status]);
        }
    }
}

function clearTable() {
    document.getElementById("r-table-body").innerHTML = "";
}