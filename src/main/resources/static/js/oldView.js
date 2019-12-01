const linne_move = document.getElementById('linne_move');
linne_move.onmousedown = e => {

    moveAt(e);
    // x2
    function moveAt(e) {
        console.log(e);
        //linne_move.setAttribute('x2', )
    }

    document.onmousemove = e => {
        console.log(e);
        let mx = e.clientX;
        let my = e.clientY;
        // let curLen = getLenOfVector(0, 0, mx, my); 
        // let z = Math.abs(line_len-curLen);

        // linne_move.setAttribute('x2', x2);
        // linne_move.setAttribute('y2', y2);
        let x = linne_move.getAttribute('x2');
        let x = linne_move.getAttribute('x2');
        

        var cos = x1*x2+y1 
    };

    linne_move.onmouseup = e => {

    };
};