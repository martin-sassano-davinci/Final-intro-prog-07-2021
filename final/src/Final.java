import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

class Final {

	public static void main(String[] args) {

		int ingreso;

		ingreso = Integer.parseInt(JOptionPane.showInputDialog(
				"Elija el juego que desee jugar.\n- 1 para Blackjack.\n- 2 para Slots.\n- 3 para Craps.\n- 4 para Piedra, papel o tijera"));

		if (ingreso == 1) {
			// blackjack //
			JOptionPane.showMessageDialog(null,
					"Bienvenido al juego: BlackJack! \n - El objetivo es simple: ganarle al Croupier obteniendo el puntaje más cercano a 21.\n - Se reparten dos cartas para cada jugador, si necesita otra carta, pidala cuando se le indique.\n - Si sus cartas totalizan un valor más cercano a 21 que las del Croupier, usted gana y se le paga el valor de la apuesta x2.\n - El Croupier deberá plantarse con un total de 17 o más y deberá tomar una carta más si tiene 16 o menos.\n - El As vale 11 o 1 dependiendo de la conveniencia del jugador.\n - Si se pasa de 21, pierde.",
					"BlackJack.", JOptionPane.WARNING_MESSAGE,
					new ImageIcon(Final.class.getResource("/bj/blackjack.jpg")));
		} else if (ingreso == 2) {
			// slots //
			JOptionPane.showMessageDialog(null,
					"Reglas:\n- Elija sus 3 numeros del 1 al 7. \n- Si acierta los 3 numeros, gana x5. \n- Si acierta solo 2 numeros, gana x2.\n- Si no acierta ningun numero, pierde todo.\n- Jackpot: Si usted elige tres numero 7 y acierta los 3 numeros, gana x50 ",
					"Bienvenido a Maquina tragaperras!!", JOptionPane.PLAIN_MESSAGE,
					new ImageIcon(Final.class.getResource("/img/craps.gif")));
		} else if (ingreso == 3) {
			// craps //
			JOptionPane.showMessageDialog(null,
					"Reglas: Se juega con 3 dados.\n- Primer tirada: \n- Si la suma de los 3 dados es 3 o 18, triplica su apuesta.\n- Pierde todo si la suma de los 3 dados es 6, 9 o 12.\n- En caso de no acertar ninguno de los numeros mencionados anteriormente, obtiene una segunda tirada.\n- Segunda tirada:\n- Se generan los valores de los 3 dados y si todos son iguales, multiplica su apuesta.\n- Si alguno de los dados es 1, cobra 10$.\n- Si hay 2 dados iguales, no gana ni pierde, se le devuelve su apuesta.\n- De lo contrario, pierde todo.",
					"Bienvenido a Craps!!", JOptionPane.PLAIN_MESSAGE,
					new ImageIcon(Final.class.getResource("/img/craps.gif")));
		} else if (ingreso == 4) {
			// piedra, papel o tijera //
			JOptionPane.showMessageDialog(null,
					"Bienvenido al juego: Piedra, Papel o Tijera! \n - Para entender las reglas, podes mirar la imagen de la izquierda o leer las siguientes instrucciones.\n - Papel>Piedra, Tijera>Papel, Piedra>Tijera, mismo objeto elegido por ambos se considera empate.",
					"Piedra, Papel o Tijera.", JOptionPane.WARNING_MESSAGE,
					new ImageIcon(Final.class.getResource("/img/Piedra_papel_tijeras.jpg")));
		} else {
			JOptionPane.showMessageDialog(null, "Error en el ingreso");
		}
		switch (ingreso) {
		case 1:
			// Blackjack //
			int[] humano = new int[10];
			int[] maquina = new int[10];
			int preg1;
			double apuesta3;
			String cont;
			String preg;
			do {
				int acumaq = 0, acuhum = 0;

				apuesta3 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese apuesta"));
				for (int i = 0; i < 2; i++) {
					humano[i] = (int) (Math.random() * 10 + 2);
					JOptionPane.showMessageDialog(null, "Carta humano: " + humano[i], "BlackJack Tirada Humano",
							JOptionPane.PLAIN_MESSAGE,
							new ImageIcon(Final.class.getResource("/bj/" + humano[i] + ".png")));
					System.out.println("Humano carta: " + humano[i]);
					acuhum = acuhum + humano[i];
					if (humano[i] == 11) {
						preg1 = Integer.parseInt(JOptionPane.showInputDialog("El As quiere que valga 1 o 11?"));
						if (preg1 == 1) {
							acuhum = acuhum - 10;
						} else if (preg1 != 11) {
							JOptionPane.showMessageDialog(null, "Error en el ingreso");
						}
					}
					JOptionPane.showMessageDialog(null, "Total cartas Humano: " + acuhum);

					System.out.println("Suma cartas humano: " + acuhum);
					if (i == 1 && acuhum < 22) {
						preg = JOptionPane.showInputDialog("Desea sacar otra carta? Si/No");
						if (preg.equalsIgnoreCase("si")) {
							i = i - 1;
						}

					}

				}

				for (int i = 0; i < 2; i++) {
					maquina[i] = (int) (Math.random() * 10 + 2);
					System.out.println("Maquina carta: " + maquina[i]);
					acumaq = acumaq + maquina[i];

					if (maquina[i] == 11 && acumaq > 21) {
						acumaq = acumaq - 10;
					}
					JOptionPane.showMessageDialog(null, "Carta maquina: " + maquina[i], "BlackJack Tirada Maquina",
							JOptionPane.PLAIN_MESSAGE,
							new ImageIcon(Final.class.getResource("/bj/" + maquina[i] + ".png")));
					System.out.println("Suma cartas maquina: " + acumaq);
					JOptionPane.showMessageDialog(null, "Total cartas maquina: " + acumaq);
					if (acumaq < 17 && acumaq <= 22 && i == 1) {
						i = i - 1;
					}
				}
				if (acuhum > 21) {
					JOptionPane.showMessageDialog(null, "Usted perdio!! Intente otra vez", "Resultado del juego",
							JOptionPane.WARNING_MESSAGE, new ImageIcon(Final.class.getResource("/img/lose2.gif")));
				} else if (acumaq > acuhum && acumaq < 22) {
					JOptionPane.showMessageDialog(null, "Usted perdio!! Intente otra vez", "Resultado del juego",
							JOptionPane.WARNING_MESSAGE, new ImageIcon(Final.class.getResource("/img/lose2.gif")));
				} else if (acuhum == acumaq && acuhum < 22) {
					JOptionPane.showMessageDialog(null,
							"Empate!! No pierde, no gana. Se le devuelve la apuesta!! Intente otra vez",
							"Resultado del juego", JOptionPane.WARNING_MESSAGE,
							new ImageIcon(Final.class.getResource("/img/tied.gif")));
				} else if (acuhum > acumaq && acuhum < 22) {
					apuesta3 = apuesta3 * 2;
					JOptionPane.showMessageDialog(null, "Felicitaciones!!" + "\n Usted gano: " + apuesta3 + "$",
							"Resultado del juego", JOptionPane.WARNING_MESSAGE,
							new ImageIcon(Final.class.getResource("/img/tenor.gif")));
				} else if (acuhum < 22 && acumaq > 21) {
					apuesta3 = apuesta3 * 2;
					JOptionPane.showMessageDialog(null, "Felicitaciones!!" + "\n Usted gano: " + apuesta3 + "$",
							"Resultado del juego", JOptionPane.WARNING_MESSAGE,
							new ImageIcon(Final.class.getResource("/img/tenor.gif")));
				}

				cont = JOptionPane.showInputDialog("Desea seguir jugando Blackjack? Si/No");
				if (cont.equalsIgnoreCase("no")) {
					JOptionPane.showMessageDialog(null, "Vuelva a jugar pronto!!", "Salir", JOptionPane.WARNING_MESSAGE,
							new ImageIcon(Final.class.getResource("/img/gameover1.gif")));
				}
			} while (cont.equalsIgnoreCase("Si"));
			break;
		case 2:
			// Slots //
			int[] hum = new int[3];
			int[] maq = new int[3];
			double apuesta;
			String cont3;
			do {
				apuesta = Double.parseDouble(JOptionPane.showInputDialog("Ingrese su apuesta"));
				for (int i = 0; i < 3; i++) {
					maq[i] = (int) (Math.random() * 7 + 1);
					System.out.println("Maquina eligio: " + maq[i]);
					hum[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero del 1 al 7"));
					System.out.println("Humano eligio: " + hum[i]);
					if (hum[i] < 1 || hum[i] > 7) {
						JOptionPane.showMessageDialog(null, "Error en el ingreso de numero");
						i = i - 1;
					}
				}
				if (hum[0] == maq[0] && hum[1] == maq[1] && hum[2] == maq[2]) {
					apuesta = apuesta * 5;
					JOptionPane.showMessageDialog(null, "Felicitaciones!!" + "\n Usted gano: " + apuesta + "$",
							"Resultado del juego", JOptionPane.WARNING_MESSAGE,
							new ImageIcon(Final.class.getResource("/img/tenor.gif")));
				} else if (hum[0] == maq[0] && hum[1] == maq[1] || hum[2] == maq[2] && hum[1] == maq[1]
						|| hum[2] == maq[2] && hum[0] == hum[0]) {
					apuesta = apuesta * 2;
					JOptionPane.showMessageDialog(null, "Felicitaciones!!" + "\n Usted gano: " + apuesta + "$",
							"Resultado del juego", JOptionPane.WARNING_MESSAGE,
							new ImageIcon(Final.class.getResource("/img/tenor.gif")));
				} else if (hum[0] == 7 && maq[0] == 7 && hum[1] == 7 && maq[1] == 7 && hum[2] == 7 && maq[2] == 7) {
					apuesta = apuesta * 50;
					JOptionPane.showMessageDialog(null,
							"Felicitaciones!! Jackpot!!" + "\n Usted gano: " + apuesta + "$", "Resultado del juego",
							JOptionPane.WARNING_MESSAGE, new ImageIcon(Final.class.getResource("/img/tenor.gif")));
				} else {
					JOptionPane.showMessageDialog(null, "Usted perdio!! Intente otra vez", "Resultado del juego",
							JOptionPane.WARNING_MESSAGE, new ImageIcon(Final.class.getResource("/img/lose2.gif")));
				}

				cont3 = JOptionPane.showInputDialog("Desea seguir jugando a Slots? Si/No");
				if (cont3.equalsIgnoreCase("no")) {
					JOptionPane.showMessageDialog(null, "Vuelva a jugar pronto!!", "Salir", JOptionPane.WARNING_MESSAGE,
							new ImageIcon(Final.class.getResource("/img/gameover1.gif")));
				}
			} while (cont3.equalsIgnoreCase("Si"));

			break;
		case 3:
			// Craps //
			String preg4;
			double apuesta4;
			int dado1, dado2, dado3, suma;

			do {

				apuesta4 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese apuesta"));
				for (int i = 0; i < 1; i++) {
					dado1 = (int) (Math.random() * 6 + 1);
					JOptionPane.showMessageDialog(null, "dado 1: " + dado1, "Ronda 1 - Tirada dado 1",
							JOptionPane.PLAIN_MESSAGE,
							new ImageIcon(Final.class.getResource("/img/dado" + dado1 + ".png")));
					dado2 = (int) (Math.random() * 6 + 1);
					JOptionPane.showMessageDialog(null, "dado 2: " + dado2, "Ronda 1 - Tirada dado 2",
							JOptionPane.PLAIN_MESSAGE,
							new ImageIcon(Final.class.getResource("/img/dado" + dado2 + ".png")));
					dado3 = (int) (Math.random() * 6 + 1);
					JOptionPane.showMessageDialog(null, "dado 3: " + dado3, "Ronda 1 - Tirada dado 3",
							JOptionPane.PLAIN_MESSAGE,
							new ImageIcon(Final.class.getResource("/img/dado" + dado3 + ".png")));
					suma = dado1 + dado2 + dado3;
					if (suma == 3 || suma == 18) {
						apuesta4 = apuesta4 * 3;
						JOptionPane.showMessageDialog(null, "Felicitaciones!!" + "\n Usted gano: " + apuesta4 + "$",
								"Resultado del juego", JOptionPane.WARNING_MESSAGE,
								new ImageIcon(Final.class.getResource("/img/tenor.gif")));
					} else if (suma == 6 || suma == 9 || suma == 12) {

						JOptionPane.showMessageDialog(null, "Usted perdio!! Intente otra vez", "Resultado del juego",
								JOptionPane.WARNING_MESSAGE, new ImageIcon(Final.class.getResource("/img/lose2.gif")));
					} else {
						JOptionPane.showMessageDialog(null, "Segunda ronda a punto de comenzar!!");
						dado1 = (int) (Math.random() * 6 + 1);
						JOptionPane.showMessageDialog(null, "dado 1: " + dado1, "Ronda 2 - Tirada dado 1",
								JOptionPane.PLAIN_MESSAGE,
								new ImageIcon(Final.class.getResource("/img/dado" + dado1 + ".png")));
						dado2 = (int) (Math.random() * 6 + 1);
						JOptionPane.showMessageDialog(null, "dado 2: " + dado2, "Ronda 2 - Tirada dado 2",
								JOptionPane.PLAIN_MESSAGE,
								new ImageIcon(Final.class.getResource("/img/dado" + dado2 + ".png")));
						dado3 = (int) (Math.random() * 6 + 1);
						JOptionPane.showMessageDialog(null, "dado 3: " + dado3, "Ronda 2 - Tirada dado 3",
								JOptionPane.PLAIN_MESSAGE,
								new ImageIcon(Final.class.getResource("/img/dado" + dado3 + ".png")));

						if (dado1 == dado2 && dado1 == dado3 && dado2 == dado3) {
							apuesta4 = apuesta4 * 2;
							JOptionPane.showMessageDialog(null, "Felicitaciones!!" + "\n Usted gano: " + apuesta4 + "$",
									"Resultado del juego", JOptionPane.WARNING_MESSAGE,
									new ImageIcon(Final.class.getResource("/img/tenor.gif")));
						} else if (dado1 == 1 || dado2 == 1 || dado3 == 1) {
							apuesta4 = apuesta4 + 10;
							JOptionPane.showMessageDialog(null, "Felicitaciones!!" + "\n Usted gano: " + apuesta4 + "$",
									"Resultado del juego", JOptionPane.WARNING_MESSAGE,
									new ImageIcon(Final.class.getResource("/img/tenor.gif")));
						} else if (dado1 == dado2 && dado1 == dado3 || dado2 == dado3 && dado2 == dado1
								|| dado2 == dado3 && dado1 == dado3) {
							JOptionPane.showMessageDialog(null,
									"No pierde, no gana. Se le devuelve la apuesta!! Intente otra vez",
									"Resultado del juego", JOptionPane.WARNING_MESSAGE,
									new ImageIcon(Final.class.getResource("/img/tied.gif")));
						} else {

							JOptionPane.showMessageDialog(null, "Usted perdio!! Intente otra vez",
									"Resultado del juego", JOptionPane.WARNING_MESSAGE,
									new ImageIcon(Final.class.getResource("/img/lose2.gif")));
						}

					}

				}

				preg4 = JOptionPane.showInputDialog("¿Quiere continuar jugando Craps? Si/No");
				if (preg4.equalsIgnoreCase("no")) {
					JOptionPane.showMessageDialog(null, "Vuelva a jugar pronto!!", "Salir", JOptionPane.WARNING_MESSAGE,
							new ImageIcon(Final.class.getResource("/img/gameover1.gif")));
				}
			} while (preg4.equalsIgnoreCase("Si"));
			break;
		case 4:
			// Piedra, papel o tijera //
			int apuesta1 = 0, apuesta2, puntosh = 0, puntosm = 0;
			String jugar, nombre;
			int[] tiradah = new int[10];
			int[] tiradam = new int[10];
			do {

				nombre = JOptionPane.showInputDialog("Ingrese su nombre!");
				apuesta1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su apuesta"));
				for (int i = 1; i <= 5; i++) {
					tiradah[i] = Integer.parseInt(JOptionPane.showInputDialog(
							"Elija su objeto con numero: \n - 1 para Piedra \n - 2 para Papel \n - 3 para Tijera \n - En caso de no elegir correctamente las opciones, pierde la ronda"));
					if (tiradah[i] == 1) {
						JOptionPane.showMessageDialog(null, nombre + " ha elegido Piedra", "Seleccion de objeto",
								JOptionPane.WARNING_MESSAGE, new ImageIcon(Final.class.getResource("/img/piedra.jpg")));
					} else if (tiradah[i] == 2) {
						JOptionPane.showMessageDialog(null, nombre + " ha elegido Papel", "Seleccion de objeto",
								JOptionPane.WARNING_MESSAGE, new ImageIcon(Final.class.getResource("/img/papel.jpg")));
					} else if (tiradah[i] == 3) {
						JOptionPane.showMessageDialog(null, nombre + " ha elegido Tijera", "Seleccion de objeto",
								JOptionPane.WARNING_MESSAGE, new ImageIcon(Final.class.getResource("img/tijera.jpg")));
					} else {
						JOptionPane.showMessageDialog(null, "Error en la seleccion del objeto");
					}

					tiradam[i] = (int) (Math.random() * 3 + 1);
					System.out.println("tiradam: " + tiradam[i]);

					if (tiradam[i] == 1) {
						JOptionPane.showMessageDialog(null, "La maquina ha elegido Piedra", "Seleccion de objeto",
								JOptionPane.WARNING_MESSAGE, new ImageIcon(Final.class.getResource("/img/piedra.jpg")));
					} else if (tiradam[i] == 2) {
						JOptionPane.showMessageDialog(null, "La maquina ha elegido Papel", "Seleccion de objeto",
								JOptionPane.WARNING_MESSAGE, new ImageIcon(Final.class.getResource("/img/papel.jpg")));
					} else {
						JOptionPane.showMessageDialog(null, "La maquina ha elegido Tijera", "Seleccion de objeto",
								JOptionPane.WARNING_MESSAGE, new ImageIcon(Final.class.getResource("/img/tijera.jpg")));
					}
					if (tiradam[i] == 1 && tiradah[i] == 3 || tiradam[i] == 2 && tiradah[i] == 1
							|| tiradam[i] == 3 && tiradah[i] == 2) {
						puntosm = puntosm + 1;

					} else if (tiradah[i] == 1 && tiradam[i] == 3 || tiradah[i] == 2 && tiradam[i] == 1
							|| tiradah[i] == 3 && tiradam[i] == 2) {

						puntosh = puntosh + 1;
					} else if (tiradam[i] == 1 && tiradah[i] == 1 || tiradam[i] == 2 && tiradah[i] == 2
							|| tiradam[i] == 3 && tiradah[i] == 3) {
						puntosh = puntosh + 0;
						puntosm = puntosm + 0;
					} else {
						puntosh = -1;
					}

				}

				if (puntosh > puntosm) {
					apuesta2 = apuesta1 * 2;
					JOptionPane.showMessageDialog(null,
							"Felicitaciones " + nombre + "!!" + "\n Usted gano: " + apuesta2 + "$",
							"Resultado del juego", JOptionPane.WARNING_MESSAGE,
							new ImageIcon(Final.class.getResource("/img/tenor.gif")));
				} else if (puntosm > puntosh) {
					JOptionPane.showMessageDialog(null, "Usted perdio!! Intente otra vez", "Resultado del juego",
							JOptionPane.WARNING_MESSAGE, new ImageIcon(Final.class.getResource("/img/lose2.gif")));
				} else {
					JOptionPane.showMessageDialog(null, "Empate!! Intente otra vez", "Resultado del juego",
							JOptionPane.WARNING_MESSAGE, new ImageIcon(Final.class.getResource("/img/tied.gif")));
				}
				jugar = JOptionPane.showInputDialog("¿Quiere volver a jugar? \nIngrese Si o No");
				if (jugar.equalsIgnoreCase("no")) {
					JOptionPane.showMessageDialog(null, "Vuelva a jugar pronto!!", "Salir", JOptionPane.WARNING_MESSAGE,
							new ImageIcon(Final.class.getResource("/img/gameover1.gif")));
				}
			} while (jugar.equalsIgnoreCase("si"));
			break;
		default:
			JOptionPane.showMessageDialog(null, "Error en la seleccion de juego, numero ingresado no valido.");
			break;
		}

	}

}
