import * as React from "react";
import { Link, useHistory } from "react-router-dom";
import "../../../../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "./Register.css";
import registerService from "../../../services/login.service";
// ---- Material UI imports ----
import Avatar from "@mui/material/Avatar";
import Button from "@mui/material/Button";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";
import { Link as MuLink } from "@mui/material";
import Grid from "@mui/material/Grid";
import Box from "@mui/material/Box";
import LockOutlinedIcon from "@mui/icons-material/LockOutlined";
import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container";
import Radio from "@mui/material/Radio";
import RadioGroup from "@mui/material/RadioGroup";
import FormControlLabel from "@mui/material/FormControlLabel";
import FormControl from "@mui/material/FormControl";
import FormLabel from "@mui/material/FormLabel";
import { createTheme, ThemeProvider } from "@mui/material/styles";

function Register() {
  const [isCustomer, setIsCustomer] = React.useState(true);

  function toggle(value) {
    setIsCustomer(value);
  }

  function Copyright(props) {
    return (
      <Typography
        variant="body2"
        color="text.secondary"
        align="center"
        {...props}
      >
        {"Copyright © "}
        <Link to="/" className="text-decoration-underline pe-auto">
          Cropify
        </Link>{" "}
        {new Date().getFullYear()}
        {"."}
      </Typography>
    );
  }

  const defaultTheme = createTheme();
  const history = useHistory();

  // ----- Registration operation -----
  const register = async (e) => {
    e.preventDefault();

    const formData = new FormData(e.target);
    console.log(formData);
    const userData = {
      firstName: formData.get("firstName"),
      lastName: formData.get("lastName"),
      mobileNo: formData.get("mobileNo"),
      email: formData.get("email"),
      password: formData.get("password"),
      userAddress: {
        city: formData.get("city"),
        state: formData.get("state"),
        pincode: formData.get("pincode"),
        fullAddress: formData.get("fullAddress"),
      },
      userType: formData.get("userType"),
      aadharNo: formData.get("aadharNo"), // To change
      panNo: formData.get("panNo"), // To change
      status: "",
    };

    await registerService
      .registerUser(userData)
      .then((res) => {
        if (res.status === 201) {
          console.log(res.data);
          history.replace("/login");
        }
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <>
      <ThemeProvider theme={defaultTheme}>
        <Container component="main" maxWidth="sm">
          <CssBaseline />
          <Box
            sx={{
              marginTop: 8,
              display: "flex",
              flexDirection: "column",
              alignItems: "center",
            }}
          >
            <Avatar sx={{ m: 1, bgcolor: "secondary.main" }}>
              <LockOutlinedIcon />
            </Avatar>
            <Typography component="h1" variant="h5">
              User Registration
            </Typography>
            <Box component="form" noValidate onSubmit={register} sx={{ mt: 3 }}>
              <Grid container spacing={2}>
                <Grid item xs={12} sm={6}>
                  <TextField
                    autoComplete="given-name"
                    name="firstName"
                    required
                    fullWidth
                    id="firstName"
                    label="First Name"
                    autoFocus
                  />
                </Grid>
                <Grid item xs={12} sm={6}>
                  <TextField
                    required
                    fullWidth
                    id="lastName"
                    label="Last Name"
                    name="lastName"
                    autoComplete="family-name"
                  />
                </Grid>
                <Grid item xs={12} sm={6}>
                  <TextField
                    required
                    fullWidth
                    id="email"
                    label="Email Address"
                    name="email"
                    autoComplete="email"
                  />
                </Grid>
                <Grid item xs={12} sm={6}>
                  <TextField
                    required
                    fullWidth
                    name="password"
                    label="Password"
                    type="password"
                    id="password"
                    autoComplete="new-password"
                  />
                </Grid>
                <Grid item xs={12}>
                  <FormControl>
                    <FormLabel id="demo-row-radio-buttons-group-label">
                      User Type
                    </FormLabel>
                    <RadioGroup
                      row
                      aria-labelledby="demo-row-radio-buttons-group-label"
                      name="userType"
                    >
                      <FormControlLabel
                        value="CUSTOMER"
                        control={<Radio />}
                        label="Customer"
                        onClick={() => toggle(true)}
                      />
                      <FormControlLabel
                        value="FARMER"
                        control={<Radio />}
                        label="Farmer"
                        onClick={() => toggle(false)}
                      />
                      <FormControlLabel
                        value="SELLER"
                        control={<Radio />}
                        label="Seller"
                        onClick={() => toggle(false)}
                      />
                    </RadioGroup>
                  </FormControl>
                </Grid>
                {!isCustomer && (
                  <Grid item xs={12} sm={6}>
                    <TextField
                      required
                      fullWidth
                      id="aadharNo"
                      label="Aadhar Number"
                      name="aadharNo"
                    />
                  </Grid>
                )}
                {!isCustomer && (
                  <Grid item xs={12} sm={6}>
                    <TextField
                      required
                      fullWidth
                      id="panNo"
                      label="PAN Card Number"
                      name="panNo"
                    />
                  </Grid>
                )}

                <Grid item xs={12} sm={6}>
                  <TextField
                    required
                    fullWidth
                    id="mobileNo"
                    label="Mobile"
                    name="mobileNo"
                  />
                </Grid>
                <Grid item xs={12} sm={6}>
                  <TextField
                    required
                    fullWidth
                    id="city"
                    label="City"
                    name="city"
                  />
                </Grid>
                <Grid item xs={12} sm={6}>
                  <TextField
                    required
                    fullWidth
                    id="state"
                    label="State"
                    name="state"
                  />
                </Grid>
                <Grid item xs={12} sm={6}>
                  <TextField
                    required
                    fullWidth
                    id="pincode"
                    label="Pincode"
                    name="pincode"
                  />
                </Grid>
                <Grid item xs={12}>
                  <TextField
                    required
                    fullWidth
                    id="fullAddress"
                    label="Full Address"
                    name="fullAddress"
                  />
                </Grid>
              </Grid>
              <Button
                type="submit"
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2 }}
              >
                Register
              </Button>
              <Grid container justifyContent="flex-end">
                <Grid item>
                  <Link to="/login">
                    <MuLink variant="body2">
                      Already have an account? Sign in
                    </MuLink>
                  </Link>
                </Grid>
              </Grid>
            </Box>
          </Box>
          <Copyright sx={{ mt: 5 }} />
        </Container>
      </ThemeProvider>
    </>
  );
}

export default Register;
