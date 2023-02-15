function renderLatex(text) {
    var invisible_div = document.createElement("div");
    invisible_div.style.cssText = "display:hidden";
    attr = document.createAttribute("id");
    attr.value = "mathjax_text";

    invisible_div.setAttributeNode(attr);
    invisible_div.innerHTML = text;
    document.body.appendChild(invisible_div);

    elem = document.getElementById("mathjax_text");
    if (window.MathJax) {
        MathJax.Hub.Queue(["Typeset", MathJax.Hub, elem]);
    }
    child_node = document.body.removeChild(elem);
    return child_node.innerHTML;
}

function latexifyAjaxDiv(div) {
    setTimeout(function() {
        if (window.MathJax) {
            MathJax.Hub.Queue(["Typeset", MathJax.Hub, div[0]]);
        }
    }, 10);
}
