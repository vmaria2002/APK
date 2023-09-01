from kivy.app import  App
from kivy.uix.boxlayout import BoxLayout
from kivy.uix.button import Button
from kivy.uix.textinput import TextInput
from kivy.uix.dropdown import DropDown
from kivy.uix.checkbox import CheckBox

import time

class MainApp(App):
    def build(self):
        self.icon="./images/bec.jpg"
        self.operation = ["lumina albastra", "lumina galbana", "buzzer", "Veioza 1", "Veioza 2", "lumina albastra+buzzer", "lumina galbena+buzzer", "Veioze Sincronizate"]


        main_layout = BoxLayout(orientation = "vertical")
        self.solution = TextInput(background_color = "green", foreground_color="white")



        main_layout.add_widget(self.solution)
        buttons = [
            ["lumina albastra"],[ "lumina galbana", "buzzer","Veioza 1"],
            ["Veioza 2", "lumina albastra+buzzer"],
            ["lumina galbena+buzzer", "Veioze Sincronizate"]
        ]
        for row in buttons:
             h_layout = BoxLayout()
             for label in row:
                button = Button(
                    text = label, font_size=30, background_color="grey", disabled= True,
                    pos_hint = {"center_x":0.5, "center_y":0.5},
                )
                button.bind(on_press = on_button_press)
                h_layout.add_widget(button)
             main_layout.add_widget(h_layout)

             button_lumina_albastra = Button(
                    text = "Lumina Albasta", font_size=30, background_color="grey",
                    pos_hint = {"center_x":0.5, "center_y":0.5})

             button_lumina_albastra.bind(on_press= on_solution)

             main_layout.add_widget(button_lumina_albastra)



             start_time = time.time()

             # The thing to time. Using sleep as an example
             self.solution.text ="ok"



             return main_layout


def on_checkbox_active(checkbox, value):
    if value:
        print('The checkbox', checkbox, 'is active')
    else:
        print('The checkbox', checkbox, 'is inactive')

def on_button_press(self):
    current = self.solution.text
    self.solution.text = "Blue Flicker"


def on_solution(self):
    text = self.solution.text

def tim(solution):
    for i in range(0, 5):
        solution.text= f'{i}'
        time.sleep((1))
if __name__ == "__main__":
    app = MainApp()
    app.run()
    tim()


