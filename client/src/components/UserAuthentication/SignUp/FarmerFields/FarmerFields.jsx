import { Button, Col, Form, Row } from 'react-bootstrap';

function FarmerFields() {
  return (
    <Form className='text-start px-3 fs-5'>
      <Row className="mb-3">
        <Form.Group as={Col} controlId="formFarmerFirstName">
          <Form.Label>First Name</Form.Label>
          <Form.Control type="text" placeholder="Enter first name" />
        </Form.Group>

        <Form.Group as={Col} controlId="formFarmerLastName">
          <Form.Label>Last Name</Form.Label>
          <Form.Control type="text" placeholder="Enter last name" />
        </Form.Group>
      </Row>

      <Row className="mb-3">
        <Form.Group as={Col} controlId="formFarmerEmail">
          <Form.Label>Email</Form.Label>
          <Form.Control type="email" placeholder="Enter email" />
        </Form.Group>

        <Form.Group as={Col} controlId="formFarmerPassword">
          <Form.Label>Password</Form.Label>
          <Form.Control type="password" placeholder="Password" />
        </Form.Group>
      </Row>

      <Form.Group className="mb-3" controlId="formFarmerAddress1">
        <Form.Label>Address</Form.Label>
        <Form.Control placeholder="1234 Main St" />
      </Form.Group>

      <Row className="mb-3">
        <Form.Group as={Col} controlId="formFarmerCity">
          <Form.Label>City</Form.Label>
          <Form.Control />
        </Form.Group>

        <Form.Group as={Col} controlId="formFarmerState">
          <Form.Label>State</Form.Label>
          <Form.Select defaultValue="Choose...">
            <option>Choose...</option>
            <option>Maharashtra</option>
            <option>Gujarat</option>
            <option>Rajasthan</option>
          </Form.Select>
        </Form.Group>

        <Form.Group as={Col} controlId="formFarmerZip">
          <Form.Label>Zip</Form.Label>
          <Form.Control type="number" placeholder="eg: 440015" />
        </Form.Group>
      </Row>

      <center>
        <Row className='w-25'>
          <Form.Group className="mb-3 text-start" id="formFarmerCheckbox">
            <Form.Check type="checkbox" label="I am Farmer" />
          </Form.Group>

          <Button variant="success" size="lg" type="submit">
            Register
          </Button>
        </Row>
      </center>
    </Form>
  );
}

export default FarmerFields;