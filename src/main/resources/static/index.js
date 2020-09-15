const rootElement = document.getElementById("root");

ReactDOM.render(
    <React.StrictMode>
        <App />
    </React.StrictMode>,
    rootElement
);

function getAssignmentList(callback) {
    fetch("/getAssignments", {
        method: "POST",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json"
        },
    }).then((response) => {
        if (!response.ok) {
            throw new Error("Unable to submit your assignment");
        }

        response.text().then(text => {
            let testResult = JSON.parse(text);
            let assignments = parseAssignmentList(testResult["allAssignments"]);
            RenderPage(assignments);
        });
    });
}

function parseAssignmentList(assignmentList) {
    let assignments = {};
    for (const assignment of assignmentList) {
        if (assignment.includes(',')) {
            let assignSplit = assignment.split(',');
            if (assignments.hasOwnProperty(assignSplit[0])){
                assignments[assignSplit[0]].push(assignSplit[1])
            } else {
                assignments[assignSplit[0]] = [assignSplit[1]]
            }
        } else {
            assignments[assignment] = [];
        }
    }
    return assignments;
}

function RenderPage(assignments) {
    const userFormElement = document.getElementById("userForm");
    ReactDOM.render(<UserForm assignments={assignments}/>, userFormElement);

    const testResultElement = document.getElementById("testResults");
    ReactDOM.render(
        <div class="card testResult">
            <h5 class="card-header">Test Results Display</h5>
            <div class="card-body">
                <div id="testTable"></div>
            </div>
        </div>,
        testResultElement
    );
}

getAssignmentList();


