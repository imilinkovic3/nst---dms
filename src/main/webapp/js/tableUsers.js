function edit_row(no)
{
    document.getElementById("edit_button"+no).style.display="none";
    document.getElementById("save_button"+no).style.display="block";

    var firstname=document.getElementById("firstname_row"+no);
    var username=document.getElementById("username_row"+no);
    var role=document.getElementById("role_row"+no);

    var firstname_data=firstname.innerHTML;
    var username_data=username.innerHTML;
    var role_data=role.innerHTML;

    firstname.innerHTML="<input type='text' id='firstname_text"+no+"' value='"+firstname_data+"'>";
    username.innerHTML="<input type='text' id='username_text"+no+"' value='"+username_data+"'>";
    role.innerHTML="<input type='text' id='role_text"+no+"' value='"+role_data+"'>";
}

function save_row(no)
{
    var firstname_val=document.getElementById("firstname_text"+no).value;
    var username_val=document.getElementById("username_text"+no).value;
    var role_val=document.getElementById("role_text"+no).value;

    document.getElementById("firstname_row"+no).innerHTML=firstname_val;
    document.getElementById("username_row"+no).innerHTML=username_val;
    document.getElementById("role_row"+no).innerHTML=role_val;

    document.getElementById("edit_button"+no).style.display="block";
    document.getElementById("save_button"+no).style.display="none";
}

function delete_row(no)
{
    document.getElementById("row"+no+"").outerHTML="";
}

function add_row()
{
    var new_firstname=document.getElementById("new_firstname").value;
    var new_username=document.getElementById("new_username").value;
    var new_role=document.getElementById("new_role").value;

    var table=document.getElementById("data_table");
    var table_len=(table.rows.length)-1;
    var row = table.insertRow(table_len).outerHTML="<tr id='row"+table_len+"'><td id='firstname_row"+table_len+"'>"+new_firstname+"</td><td id='username_row"+table_len+"'>"+new_username+"</td><td id='role_row"+table_len+"'>"+new_role+"</td><td><input type='button' id='edit_button"+table_len+"' value='Edit' class='edit' onclick='edit_row("+table_len+")'> <input type='button' id='save_button"+table_len+"' value='Save' class='save' onclick='save_row("+table_len+")'> <input type='button' value='Delete' class='delete' onclick='delete_row("+table_len+")'></td></tr>";

    document.getElementById("new_firstname").value="";
    document.getElementById("new_username").value="";
    document.getElementById("new_role").value="";
}