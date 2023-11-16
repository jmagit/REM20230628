import { Inject, Injectable, InjectionToken, Optional, isDevMode } from '@angular/core';

export const ERROR_LEVEL = new InjectionToken<string>('ERROR_LEVEL')

@Injectable()
export class LoggerService {
  private readonly nivel: number

  constructor(@Optional() @Inject(ERROR_LEVEL) nivel?: number) {
    if(nivel || nivel == 0) {
      this.nivel = nivel
    } else {
      this.nivel = 99
    }
  }

  public error(msg: string): void {
    if (this.nivel > 0) {
      console.error(msg)
    }
  }
  public warn(msg: string): void {
    if (this.nivel > 1) {
      console.warn(msg)
    }
  }
  public info(msg: string): void {
    if (this.nivel > 2) {
      if (console.info) {
        console.info(msg)
      } else {
        console.log(msg)
      }
    }
  }
  public log(msg: string): void {
    if (this.nivel > 3) {
      console.log(msg)
    }
  }
  /**
   * Mensajes en modo desarrollo
   * @param msg
   */
  public trace(msg: string): void {
    if (isDevMode() && this.nivel > 4) {
      console.log(msg)
    }
  }
}
