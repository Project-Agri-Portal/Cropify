import { Link } from 'react-router-dom/cjs/react-router-dom.min';
import blogBg from '../../../assets/home-bg.jpg';
import './BlogPage.css';
// import '../../../../node_modules/bootstrap/dist/css/bootstrap.min.css';

function BlogPage() {
  return (
    <>
      <nav className="navbar navbar-expand-lg navbar-light" id="mainNav">
        <div className="container px-4 px-lg-5">
          <Link className="navbar-brand" to="/">Cropify</Link>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i className="fas fa-bars"></i>
          </button>
          <div className="collapse navbar-collapse" id="navbarResponsive">
            <ul className="navbar-nav ms-auto py-4 py-lg-0">
              <li className="nav-item"><Link className="nav-link px-lg-3 py-3 py-lg-4" to="/blog">Home</Link></li>
              <li className="nav-item"><Link className="nav-link px-lg-3 py-3 py-lg-4" to="/blog/about">About</Link></li>
              <li className="nav-item"><Link className="nav-link px-lg-3 py-3 py-lg-4" to="/blog/post">Sample Post</Link></li>
            </ul>
          </div>
        </div>
      </nav>
      {/* <!-- Page Header--> */}
      <header className="masthead" style={{ backgroundImage: `url(${blogBg})` }}>
        <div className="container position-relative px-4 px-lg-5">
          <div className="row gx-4 gx-lg-5 justify-content-center">
            <div className="col-md-10 col-lg-8 col-xl-7">
              <div className="site-heading">
                <h1>Farmer Blogs</h1>
                <span className="subheading">A place where farmers share their views</span>
              </div>
            </div>
          </div>
        </div>
      </header>
      {/* <!-- Main Content--> */}
      <div className="container px-4 px-lg-5">
        <div className="row gx-4 gx-lg-5 justify-content-center">
          <div className="col-md-10 col-lg-8 col-xl-7">
            {/* <!-- Post preview--> */}
            <div className="post-preview">
              <a href="post.html">
                <h2 className="post-title">Man must explore, and this is exploration at its greatest</h2>
                <h3 className="post-subtitle">Problems look mighty small from 150 miles up</h3>
              </a>
              <p className="post-meta">
                <span>Posted by Farmer Name</span>
                {/* <a href="#!">Farmer Name</a> */}
                <span>on December 24, 2023</span>
              </p>
            </div>
            {/* <!-- Divider--> */}
            <hr className="my-4" />
            {/* <!-- Post preview--> */}
            <div className="post-preview">
              <a href="post.html"><h2 className="post-title">I believe every human has a finite number of heartbeats. I don't intend to waste any of mine.</h2></a>
              <p className="post-meta">
                <span>Posted by Farmer Name</span>
                {/* <a href="#!">Farmer Name</a> */}
                <span>on December 18, 2023</span>
              </p>
            </div>
            {/* <!-- Divider--> */}
            <hr className="my-4" />
            {/* <!-- Post preview--> */}
            <div className="post-preview">
              <a href="post.html">
                <h2 className="post-title">Science has not yet mastered prophecy</h2>
                <h3 className="post-subtitle">We predict too much for the next year and yet far too little for the next ten.</h3>
              </a>
              <p className="post-meta">
                <span>Posted by Farmer Name</span>
                {/* <a href="#!">Farmer Name</a> */}
                <span>on December 14, 2023</span>
              </p>
            </div>
            {/* <!-- Divider--> */}
            <hr className="my-4" />
            {/* <!-- Post preview--> */}
            <div className="post-preview">
              <a href="post.html">
                <h2 className="post-title">Failure is not an option</h2>
                <h3 className="post-subtitle">Many say exploration is part of our destiny, but it’s actually our duty to future generations.</h3>
              </a>
              <p className="post-meta">
                <span>Posted by Farmer Name</span>
                {/* <a href="#!">Farmer Name</a> */}
                <span>on December 8, 2023</span>
              </p>
            </div>
            {/* <!-- Divider--> */}
            <hr className="my-4" />
            {/* <!-- Pager--> */}
            <div className="d-flex justify-content-end mb-4"><a className="btn btn-primary text-uppercase" href="#!">Older Posts →</a></div>
          </div>
        </div>
      </div>
    </>
  );
}

export default BlogPage;