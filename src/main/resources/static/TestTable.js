class TestTable extends React.Component {
    constructor(props) {
        super(props);
        this.testCases = props.testCases;
    }

    render() {
        return (
            <div class="card-content">
                {
                    Object.keys(this.testCases["records"]).map((key) => (

                    <table className="table table-sm">
                        <thead><tr>{key}</tr></thead>
                        <thead>
                        <tr>
                            <th scope="col">id</th>
                            <th scope="col">Test Case</th>
                            <th scope="col">Passed</th>
                            <th scope="col">Error Message</th>
                        </tr>
                        </thead>
                        <tbody>
                        {this.testCases["records"][key].map((test) => (
                            <tr>
                                <th scope="row">{test.id}</th>
                                <td>{test["caseName"]}</td>
                                <td>{test["isPassed"]}</td>
                                <td>{test["errorMessage"]}</td>
                            </tr>
                        ))}
                        </tbody>
                    </table>
                    ))}
            </div>
        );
    }
}