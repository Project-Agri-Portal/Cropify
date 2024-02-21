import { useHistory } from "react-router-dom/cjs/react-router-dom.min";
import Card from "react-bootstrap/Card";
import Fruits from "../../../assets/InfoImages/card-fruits.webp";
import Vegetables from "../../../assets/InfoImages/card-vegetables.webp";
import Crops from "../../../assets/InfoImages/card-crops.jpg";
import Machinery from "../../../assets/InfoImages/card-machinery.jpg";

const cardTitles = ["Crops", "Fruits", "Vegetables", "Machinery"];
const cardImages = {
  Crops: Crops,
  Fruits: Fruits,
  Vegetables: Vegetables,
  Machinery: Machinery
};

function FarmerHome() {
  const history = useHistory();

  function openCard(title) {
    history.push("/home/information/" + title.toLowerCase());
  }

  return (
    <>
      <section className="container row gap-5">
        {cardTitles.map((title, index) => (
          <Card
            onClick={() => openCard(title)}
            style={{ width: "18rem" }}
            key={index}
          >
            <Card.Img variant="top" src={cardImages[title]} alt={title} />
            <Card.Body>
              <Card.Title className="text-success-emphasis fs-4 fw-semibold">
                {title}
              </Card.Title>
              {/* <Card.Text>
                Some quick example text to build on the card title and make up the
                bulk of the card's content.
                </Card.Text>
              <Button variant="primary">{title}</Button> */}
            </Card.Body>
          </Card>
        ))}
      </section>
    </>
  );
}

export default FarmerHome;
