class TestTable extends React.Component {
    constructor(props) {
        super(props);
        this.state = { tests: props.tests };
    }

    render() {
        return (
            <div class="card-content">
                <table class="table table-sm">
                    <thead>
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">Test Case</th>
                        <th scope="col">Passed</th>
                        <th scope="col">Error Message</th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.state.tests.map((test) => (
                        <tr>
                            <th scope="row">{test.id}</th>
                            <td>{test.case}</td>
                            <td>{test.passed}</td>
                            <td>{test.error}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        );
    }
}