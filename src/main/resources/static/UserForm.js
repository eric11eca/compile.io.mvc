class UserForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            value: "",
            message: "",
            assignment: "Homework 1",
            filename: "",
            fileSize: "",
            fileContent: ""
        };

        this.assignments = {
            "Homework 1": ["Basic BST", "BST+Iterator"],
            "Homework 2": ["Single Assignment"],
            "Homework 3": ["Single Assignment"]
        };

        this.handleOption = this.handleOption.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleUpload = this.handleUpload.bind(this);
        this.readFile = this.readFile.bind(this);
    }

    handleOption(event) {
        this.setState({ assignment: event.target.value });
    }

    handleChange(event) {
        this.setState({ value: event.target.value });
    }

    async handleSubmit(event) {
        event.preventDefault();

        await fetch("/upload", {
            method: "POST",
            headers: {
                Accept: "application/json",
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                username: this.state.value,
                assignment: document.getElementById("assignments").value,
                fileName: this.state.fileName,
                fileSize: this.state.fileSize,
                fileContent: this.state.fileContent
            })
        }).then((response) => {
            if (!response.ok) {
                throw new Error("Unable to submit your assignment");
            }

            response.text().then(text => {
                this.setState({ message: text });
            });
        });

        let testCases = [
            { id: 1, case: "basicInsertTest", passed: "Yes", error: "" },
            {
                id: 2,
                case: "advancedInsertTest1",
                passed: "No",
                error: "Failed at the fifth insertion"
            },
            { id: 3, case: "advancedInsertTest2", passed: "Yes", error: "" },
            {
                id: 4,
                case: "basicDeletionTest",
                passed: "No",
                error: "Failed at the fifth deletion"
            },
            { id: 5, case: "advancedDeletionTest", passed: "Yes", error: "" }
        ];

        const testTableElement = document.getElementById("testTable");
        ReactDOM.render(<TestTable testCases={testCases} />, testTableElement);
    }

    async handleUpload(event) {
        event.preventDefault();
        const uploader = document.getElementById("upload");
        const file = uploader.files[0];

        if (file) {
            let reader = new FileReader();
            reader.readAsText(file, "UTF-8");
            reader.onload = this.readFile;
            this.setState({ fileName: file.name, fileSize: file.size });
        }
    }

    async readFile(event) {
        this.setState({ fileContent: event.target.result });
    }

    render() {
        return (
            <div class="card-content">
                <div class="formRow">
                    <div class="form-component input-group flex-nowrap">
                        <div class="input-group-prepend">
              <span class="input-group-text" id="addon-wrapping">
                Username
              </span>
                        </div>
                        <input
                            value={this.state.value}
                            onChange={this.handleChange}
                            type="text"
                            class="form-control"
                            placeholder="rose username"
                            aria-label="Username"
                            aria-describedby="addon-wrapping"
                        ></input>
                    </div>
                    <div class="form-component input-group flex-nowrap">
                        <div class="input-group-prepend">
              <span class="input-group-text" id="addon-wrapping">
                Assignment:
              </span>
                        </div>
                        <select name="assignments" id="assignments" onChange={this.handleOption}>
                            {Object.keys(this.assignments).map((item) => (
                                <option>{item}</option>
                            ))}
                        </select>
                        <select name="compounds" id="compounds">
                            {
                                this.assignments[this.state.assignment].map((item) => (
                                <option>{item}</option>
                            ))}
                        </select>
                    </div>
                </div>
                <div class="formRow">
                    <input id="upload" type="file" onChange={this.handleUpload}></input>
                    <button class="btn btn-primary" onClick={this.handleSubmit}>
                        Submit
                    </button>
                </div>
                <div class="formRow">{this.state.message}</div>
            </div>
        );
    }
}
