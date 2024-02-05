import "../../../../node_modules/bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap.bundle"
import "./SpecialOffer.css"

const offer = () => {
    // Set the date we're counting down to (10 days from now)
var countDownDate = new Date();
var day = countDownDate.getDate() - 10;
countDownDate.setDate(countDownDate.getDate() + day);

// Update the countdown every 1 second
var x = setInterval(function () {
  // Get the current date and time
  var now = new Date().getTime();

  // Calculate the remaining time
  var distance = countDownDate - now;

  // Calculate days, hours, minutes, and seconds
  var days = Math.floor(distance / (1000 * 60 * 60 * 24));
  var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
  var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
  var seconds = Math.floor((distance % (1000 * 60)) / 1000);

  // Display the countdown
  document.getElementById("countdown").innerHTML =
    days + "d " + hours + "h " + minutes + "m " + seconds + "s ";

  // If the countdown is over, display a message
  if (distance < 0) {
    // clearInterval(x);
    // document.getElementById("countdown").innerHTML = "EXPIRED";
  }
}, 1000);

}

const SpecialOffer = () => {
    return(
        <>
        <div style={{height:"80px"}}></div>
        <div>
        <h2 className="text-center">Special Offer</h2>
        <hr className="hrteam" />
        <div className="underline"></div>
        <br />
        <div className="banner">
          <div className="container">
            <h2 style={{color: "rgb(51, 77, 13)"}}>Special Offer on Fruits!</h2>
            <p style={{color: "rgb(51, 77, 13)"}}>Hurry up! Limited time offer.</p>
            {/* <!-- Countdown Timer --> */}
            <div id="countdown" onLoa className="countdown"></div>
          </div>
        </div>
      </div>
      </>
    );
};

export default SpecialOffer;