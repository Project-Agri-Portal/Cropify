import * as React from "react";
import { Link, useHistory } from "react-router-dom";
import "../../../../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle";
import "./Login.css";
import loginService from "../../../services/login.service";
// ---- Material UI imports ----
import Alert from "@mui/material/Alert";
import Avatar from "@mui/material/Avatar";
import Button from "@mui/material/Button";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";
import FormControlLabel from "@mui/material/FormControlLabel";
import Checkbox from "@mui/material/Checkbox";
import { Link as MuLink } from "@mui/material";
import Grid from "@mui/material/Grid";
import Box from "@mui/material/Box";
import LockOutlinedIcon from "@mui/icons-material/LockOutlined";
import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container";
import { createTheme, ThemeProvider } from "@mui/material/styles";

function Login() {
  const [validCreds, setValidCreds] = React.useState(true);
  const defaultTheme = createTheme();
  const history = useHistory();

  // Automatic user login if credentials are already stored in local or session storage
  React.useEffect(() => {
    async function storedCreds() {
      let userId = "";
      if (localStorage.getItem("userId")) {
        userId = localStorage.getItem("userId");
      } else if (sessionStorage.getItem("userId")) {
        userId = sessionStorage.getItem("userId");
      }
      await loginService
        .getCustomer(userId)
        .then((res) => {
          const userType = res.data["userType"];
          history.replace("/home/" + userType.toLowerCase());
        })
        .catch();
    }
    if (localStorage.length || sessionStorage.length) {
      storedCreds();
    }
  });

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

  // ---------- Controlled Input operation --------------
  // const [email, setEmail] = useState();
  // const [password, setPassword] = useState();
  // const emailChange = ({target:{value}}) => setEmail(value);
  // const passwordChange = ({target:{value}}) => setPassword(value);

  // ---------- Login operation -------------------
  const userLogin = async (e) => {
    // -------- preventing the form's default behaviour ---------------
    e.preventDefault();

    // loaded the form-data in a FormData object and stored the target entity
    const loginData = new FormData(e.target);
    console.log(loginData);
    const credentials = {
      email: loginData.get("email"),
      password: loginData.get("password"),
    };

    // stored the required fields in an object and passed it to axios http method
    // using the imported file name 'backend'
    await loginService
      .loginUser(credentials)
      .then((res) => {
        console.log(res.data);
        // storing the user type (customer, farmer, seller)
        const userType = res.data["userType"] + "";

        // Redirecting to respective user type's home page on successfull login
        if (res.status === 200) {
          // Store userid on checking the Remember Me checkbox
          loginData.get("remember") === "remember"
            ? localStorage.setItem("userId", res.data["id"])
            : sessionStorage.setItem("userId", res.data["id"]);

          history.replace("/home/" + userType.toLowerCase());
        }
      })
      .catch((err) => {
        setValidCreds(false);
        console.log(err);
      });
  };

  return (
    <>
      <ThemeProvider theme={defaultTheme}>
        <Container component="main" maxWidth="xs">
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
              User Login
            </Typography>
            <Box
              component="form"
              onSubmit={userLogin}
              noValidate
              sx={{ mt: 1 }}
              className="text-start"
            >
              {!validCreds ? (
                <Alert severity="error">Invalid Credentials</Alert>
              ) : (
                <></>
              )}

              <TextField
                margin="normal"
                required
                fullWidth
                id="email"
                label="Email Address"
                name="email"
                autoComplete="email"
                autoFocus
              />
              <TextField
                margin="normal"
                required
                fullWidth
                name="password"
                label="Password"
                type="password"
                id="password"
                autoComplete="current-password"
              />
              <FormControlLabel
                control={<Checkbox value="remember" color="primary" />}
                label="Remember me"
                name="remember"
              />
              <Button
                type="submit"
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2 }}
              >
                Sign In
              </Button>
              <Grid container>
                {/* <Grid item xs>
                <Link to="#" variant="body2">
                  Forgot password?
                </Link>
              </Grid> */}
                <Grid item>
                  <MuLink
                    style={{ cursor: "pointer" }}
                    variant="body2"
                    onClick={() => {
                      history.replace("/register");
                    }}
                  >
                    {"Don't have an account? Sign Up"}
                  </MuLink>
                </Grid>
              </Grid>
            </Box>
          </Box>
          <Copyright sx={{ mt: 8, mb: 4 }} />
        </Container>
      </ThemeProvider>
    </>
  );
}

export default Login;
