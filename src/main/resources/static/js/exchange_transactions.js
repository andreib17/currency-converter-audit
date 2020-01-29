$.getJSON("/currency-convert/transactions", function (transactions) {
    var $tableBody = $("#transactions tbody");
    transactions.forEach(function (item) {
        var $line = $("<tr>");
        $line.append( $("<td>").text(item.from) );
        $line.append( $("<td>").text(item.to) );
        $line.append( $("<td>").text(item.conversionMultiple) );
        $line.append( $("<td>").text(item.quantity) );
        $line.append( $("<td>").text(item.totalCalculatedAmount) );
        $line.append( $("<td>").text(item.date) );
        $tableBody.append($line);
    })
});