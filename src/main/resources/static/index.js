const rootElement = document.getElementById("root");

ReactDOM.render(
<React.StrictMode>
<App />
</React.StrictMode>,
rootElement
);

const userFormElement = document.getElementById("userForm");
ReactDOM.render(<UserForm />, userFormElement);

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
