<div class="login">
  <h2 class="fw-bold mb-2 text-uppercase">Iniciar Sesión</h2>
  <form class="custom-form" [formGroup]="checkoutForm" (ngSubmit)="onSubmit()">
    <h2>Login</h2>

    <div class="form-outline form-white mb-4">
      <input
      type="text"
      formControlName="login"
      name="login"
      placeholder="Login"
      required="required"
      class="form-control form-control-lg"
      />

    </div>
    
    <div class="form-outline form-white mb-4">
      <input
      type="password"
      formControlName="password"
      name="password"
      placeholder="Password"
      required="required"
      class="form-control form-control-lg"
      />

    </div>
    
    <button type="submit">Ingresar</button>
  </form>
</div>
