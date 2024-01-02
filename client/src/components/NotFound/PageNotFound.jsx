const PageNotFound = () => {
  return (
    <>
      <div className="container vw-100 d-flex flex-column justify-content-center align-items-center" style={{ height: "80vh" }}>
        <h1>Error</h1>
        <h1 style={{ fontSize: "80px" }}>404</h1>
        <h2>Page Not Found</h2>
        <h5>Please verify the url you are requesting</h5>
      </div>
    </>
  );
}

export default PageNotFound;