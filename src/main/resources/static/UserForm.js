class UserForm extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            value: "",
            message: "",
            assignment: "Default",
            filename: "",
            fileSize: "",
            fileContent: ""
        };

        this.assignments = props.assignments;
        this.assignments["Default"] = [];

        this.handleOption = this.handleOption.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleUpload = this.handleUpload.bind(this);
        this.readFile = this.readFile.bind(this);
        this.composeAssignment = this.composeAssignment.bind(this);
    }

    composeAssignment() {
        if (document.getElementById("compounds").value === "") {
            return document.getElementById("assignments").value;
        }
        return document.getElementById("assignments").value+','+document.getElementById("compounds").value
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
                assignment: this.composeAssignment(),
                fileName: this.state.fileName,
                fileSize: this.state.fileSize,
                fileContent: this.state.fileContent
            })
        }).then((response) => {
            if (!response.ok) {
                throw new Error("Unable to submit your assignment");
            }

            response.text().then(text => {
                alert(text);
                let testCases = JSON.parse(text);
                const testTableElement = document.getElementById("testTable");
                testTableElement.innerHTML = "";
                ReactDOM.render(<TestTable testCases={testCases} />, testTableElement);
            });
        });
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
