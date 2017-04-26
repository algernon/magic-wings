;; Chrysalis -- Kaleidoscope Command Center
;; Copyright (C) 2017  Gergely Nagy <algernon@madhouse-project.org>
;;
;; This program is free software: you can redistribute it and/or modify
;; it under the terms of the GNU General Public License as published by
;; the Free Software Foundation, either version 3 of the License, or
;; (at your option) any later version.
;;
;; This program is distributed in the hope that it will be useful,
;; but WITHOUT ANY WARRANTY; without even the implied warranty of
;; MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
;; GNU General Public License for more details.
;;
;; You should have received a copy of the GNU General Public License
;; along with this program.  If not, see <http://www.gnu.org/licenses/>.

(ns chrysalis.app
  (:require [reagent.core :as reagent]

            [chrysalis.ui :refer [pages page state <main-menu>]]

            ;; Plugins

            [chrysalis.plugin.page.devices.core :as devices]
            [chrysalis.plugin.page.repl.core]
            [chrysalis.plugin.page.firmware.core]

            [chrysalis.plugin.Kaleidoscope.FingerPainter.core]
            [chrysalis.plugin.Kaleidoscope.LEDControl.core]

            [chrysalis.plugin.hardware.virtual.core]
            [chrysalis.plugin.hardware.model01.core]
            [chrysalis.plugin.hardware.shortcut.core]))

(enable-console-print!)

(defn root-component []
  [:div
   [<main-menu>]
   (page (:page @state))])

(defn init! []
  (devices/device-detect!))

(reagent/render
 [root-component]
  (js/document.getElementById "application"))

(init!)
