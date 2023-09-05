
function Footer() {
  let estilo = {
    backgroundColor: "rgba(0, 0, 0, 0.2)",
    bottom: "0",
    width: "100%",   
    marginTop: "auto",
  };
  return (
    <footer
      className="text-center text-white p-3 bg-dark position-absolute"
      style={estilo}
    >
      © 2023 Grupo B:{" "}
      <a className="text-white" href="#https">
        Chef en Casa
      </a>
    </footer>
  );
}

export default Footer;
