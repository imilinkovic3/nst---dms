<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form style="display: block;" id="login-form" action="/nst/login/"
           method="post">
    <div class="form-group">
        <input type="text" name="username" placeholder="Username"
               id="username" tabindex="1" class="form-control" value="">
    </div>
    <div class="form-group">
        <input type="password" name="password" id="password"
               placeholder="Password" tabindex="2" class="form-control">
    </div>
    <div class="form-group text-center">
        <input type="checkbox" tabindex="3" class="" name="remember"
               id="remember"> <label for="remember"> Remember Me</label>
    </div>
    <div class="form-group">
        <div class="row">
            <div class="col-sm-6 col-sm-offset-3">
                <input type="submit" id="login-submit" tabindex="4"
                       class="form-control btn btn-login" value="LOGIN"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="row">
            <div class="col-lg-12">
                <div class="text-center">
                    <a href="javascript:insert_email_or_username()" tabindex="5"
                       class="forgot-password" >Forgot Password?</a>
                </div>
            </div>
        </div>
    </div>

    <div class="form-group text-center">

    </div>

</form:form>


<div id="myModal" class="modal">
    <!-- Modal content -->
    <div class="modal-content">
        <span class="close">X</span>
<form:form style="display: block;" id="change_password-form" action="/nst/forgetpassword/"
           method="post">
   <p>Please insert your email or username. You will receive your new password on email. </p>
       <p>Please change your password when you access system.</p>
        <div class="form-group">
            <input type="text" name="emailOrUsername" id="emailOrUusername"
                   placeholder="email or username" class="form-control">
        </div>
        <div class="form-group">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3">
                    <input type="submit" id="change_password" tabindex="4"
                           class="form-control btn btn-login" value="CHANGE PASSWORD"/>
                </div>
            </div>
        </div>

</form:form>
    </div>

</div>
